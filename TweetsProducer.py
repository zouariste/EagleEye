import json
from kafka import KafkaProducer

FILE_PATH = "NintendoTweets.json"
producer = KafkaProducer(value_serializer=lambda v: json.dumps(v).encode('utf-8'),bootstrap_servers='192.168.99.100:9092')#send review as json
line_count = 0
for line in open(FILE_PATH, 'r'):
    if len(line)>1:
        tweet = json.loads(line)
        #print(tweet["created_at"])
        producer.send('nintendo_tweets_raw', tweet)
        line_count += 1
        print(line_count)
#print(f'sent {line_count} lines.')
producer.flush() # Block until all pending messages are at least put on the network


