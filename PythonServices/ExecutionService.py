from elasticsearch import Elasticsearch
from datetime import datetime
from geojson import Point
import json
import numpy as np
from tweepy.streaming import StreamListener
from tweepy import OAuthHandler
from tweepy import Stream
import SentimentAnalysisService as stm
import TextEditionService as te


consumer_key = "uGRJB1juQb60GHmvGVaoxnMlJ"
consumer_secret = "R4ZgR3LR0BYfPsiaz4lC5riVPrsxYVeCTJ1fVSW1bJBWBfpyDW"
access_token = "3429879328-dW91bfoGyn6OLnsBVHB2X998qTS2xSkQhfpp1r1"
access_token_secret = "KH0Wc8a74WCjdUk8HzHzWOSPXvCdnst1HV8TWocx4CdlI"

es = Elasticsearch([{'host':'127.0.0.1','port':9200}])

ThreadCount=0

def execute(id,dateexe,languages,keywords):
 
    idThread=ThreadCount
                
    def stream(a,b):
        l = StdOutListener()
        auth = OAuthHandler(consumer_key, consumer_secret)
        auth.set_access_token(access_token, access_token_secret)
        stream = Stream(auth, l)
        b=[i.lower() for i in b]
        stream.filter(track=a,languages=b)

    def Treat(message):
        try:
           
            Dict=json.loads(message)
            tweet_id = Dict["id"]
            timestamp = datetime.strptime(
            Dict['created_at'],"%a %b %d %H:%M:%S %z %Y"
            ).strftime('%Y/%m/%d %H:%M:%S')
            Dict['date']= timestamp

            tweet_text = te.textedition(Dict)

            stm.analysesentiment(tweet_text,Dict)
                
            Dict['request_id']=id
            Dict['dateexe']=dateexe

            es.index(index="dravassor",id=tweet_id, body=Dict)
        except:
            pass

    class StdOutListener(StreamListener):
        """ A listener handles tweets that are received from the stream.
        This is a basic listener that send the received tweets to The EditionService.
        """
        def on_data(self, data):
            if ((ThreadCount - idThread)>1):
                return False
            Treat(data)
            return True 

        def on_error(self, status):
            return

    stream(keywords,languages)
        


