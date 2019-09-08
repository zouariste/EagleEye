from elasticsearch import Elasticsearch

def clear():
    es = Elasticsearch([{'host':'192.168.99.100','port':9200}])
    es.indices.delete(index='dravassor')