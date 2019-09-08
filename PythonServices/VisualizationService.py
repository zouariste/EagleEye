from kafka import KafkaConsumer
import ExecutionService as exec
import ClearIndex as clear
from datetime import datetime
import json
from threading import Thread


consumer = KafkaConsumer('visualizer', 
    bootstrap_servers='192.168.99.100:9092',
    auto_offset_reset='earliest', 
    enable_auto_commit=True)
ts = datetime.now().timestamp()

'''Clear Elasticsearch Index'''
try:
    clear.clear()
except:
    pass



for message in consumer:
    if (message!=""):

        Dict = json.loads(message.value.decode('utf-8'))
        keywords=Dict["keywords"]
        languages=Dict["languages"]
        dateexe=Dict["dateexe"]
        id=Dict["id"]
        dateexe=dateexe // 1000
        dateexe2=dateexe
        date_time = datetime.fromtimestamp(dateexe)
        dateexe = date_time.strftime("%c")

        '''Execute only new visualization requests in new Threads'''
        if (ts<dateexe2):
            process = Thread(target=exec.execute, args=[id,dateexe,languages,keywords])
            exec.ThreadCount+=1
            process.start()
