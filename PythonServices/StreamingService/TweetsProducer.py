from tweepy.streaming import StreamListener
from tweepy import OAuthHandler
from tweepy import Stream
from kafka import KafkaProducer
import json


#producer = KafkaProducer(value_serializer=lambda v: json.dumps(v).encode('utf-8'),bootstrap_servers='192.168.99.100:9092')#send review as json

consumer_key = "uGRJB1juQb60GHmvGVaoxnMlJ"
consumer_secret = "R4ZgR3LR0BYfPsiaz4lC5riVPrsxYVeCTJ1fVSW1bJBWBfpyDW"
access_token = "3429879328-dW91bfoGyn6OLnsBVHB2X998qTS2xSkQhfpp1r1"
access_token_secret = "KH0Wc8a74WCjdUk8HzHzWOSPXvCdnst1HV8TWocx4CdlI"

class StdOutListener(StreamListener):
    """ A listener handles tweets that are received from the stream.
    This is a basic listener that just prints received tweets to stdout.
    """
    def on_data(self, data):
        tweet = json.loads(data)
        #producer.send('movies2', data)
        print(data)
        return True 

    def on_error(self, status):
        print(status)

if __name__ == '__main__':
    l = StdOutListener()
    auth = OAuthHandler(consumer_key, consumer_secret)
    auth.set_access_token(access_token, access_token_secret)
    stream = Stream(auth, l)
    stream.filter(track=['#trump','#google'],languages=["en","fr"])
    #Lpcation
    #is_async=True  (Run filter on a new thread)
    print("kkk")

         
                


