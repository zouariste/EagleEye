# pip install -U textblob
# python -m textblob.download_corpora
# from kafka import KafkaConsumer
# from textblob import TextBlob 
# from elasticsearch import Elasticsearch
# from datetime import datetime
# from geojson import Point
# import json
# import numpy as np


# es = Elasticsearch([{'host':'192.168.99.100','port':9200}])
# consumer = KafkaConsumer('nintendo_tweets_raw', 
#     bootstrap_servers='192.168.99.100:9092',
#     auto_offset_reset='earliest',
#     group_id='my-group',
#     auto_commit_interval_ms='1000ms', 
#     enable_auto_commit=True,
#     value_deserializer=lambda m: json.loads(m.decode('utf-8')))
# total_analyzed_tweets = 0
# for message in consumer:
#     try:
#         tweet_id = message.value["id"]
#         tweet_text = message.value["text"]
#         tweet_text_blob = TextBlob(tweet_text)
#         print('-----------------------------------------------')
#         print('msg id = ',message.value["id"])
#         print('msg content = ', tweet_text)
#         print('sentiment polarity = ', tweet_text_blob.sentiment.polarity)
#         print('sentiment subjectivity = ', tweet_text_blob.sentiment.subjectivity)
#         print(tweet_text_blob.to_json())
#         tweet_sent_doc = json.dumps({'id' : tweet_id, 'timestamp' :message.value['timestamp_ms'] , 'polarity' : tweet_text_blob.sentiment.polarity,'subjectivity' : tweet_text_blob.sentiment.subjectivity})
#         print(tweet_sent_doc)
#         timestamp = datetime.strptime(
#         message.value['created_at'],"%a %b %d %H:%M:%S %z %Y"
#         ).strftime('%Y/%m/%d %H:%M:%S')
#         print()
#         message.value['date']= timestamp
#         message.value['sentiment.polarity']=tweet_text_blob.sentiment.polarity
#         message.value['sentiment.subjectivity']=tweet_text_blob.sentiment.subjectivity
#         print(message.value['date'])
#         geo
#         message.value['place.center'] = Point(41.12,-71.34)
        
#         if message.value.get('place') and message.value.get('place').get('bounding_box') and message.value.get('place').get('bounding_box').get('coordinates'):
#             coo = np.array(message.value['place']['bounding_box']['coordinates'][0])
#             center = np.mean(coo,0)
#             print(center)
#             geo_point = Point(center[0],center[1])
#             print('--------------------------',geo_point)
#             message.value['place.center']=geo_point
#             print('-----------------------------',center,'--------------------',geo_point)
#         es.index(index="nintendo_sentiments",id=tweet_id, body=message.value)
#         total_analyzed_tweets = total_analyzed_tweets+1
#         print(total_analyzed_tweets)
#     except:
#         pass
# print('total analyzed tweets = ',total_analyzed_tweets)

from kafka import KafkaConsumer
import pandas as pd
import json
import pandas as pd
import nltk
#import spacy
#import textprocessing
#import re
#from nltk.sentiment.vader import SentimentIntensityAnalyzer as Vader

def program():
    consumer = KafkaConsumer('movies2', 
     bootstrap_servers='192.168.99.100:9092',
     auto_offset_reset='earliest',
     group_id='my-group',
     #auto_commit_interval_ms='1000ms', 
     enable_auto_commit=True,
      value_deserializer=lambda m: json.loads(m.decode('utf-8')))
    #tweets,conn, dbcur = initialize(db_name = "tweetdata")
    #tweets,conn, dbcur = initialize(db_name = "tweetdata")
    for msg in consumer:
        message = json.loads(msg.value)
        tweet_text =  msg#essage["text"]
        #print("a")
        print (tweet_text)
        print ('\n')  
  # set-up a Kafka consumer
    
  

      # Function to extract features from tweets
##      extracttweetfeatures(tweets, output)
##
##      # Text cleaning
##      cleantweettext(tweets)
##
##      # Calculate sentiment using nltk vader sentiment library
##      calculatesentiments(tweets)
##
##      # Create data frame
##      cleanse_dataframe_and_load(tweets, conn, dbcur)
program()

    
