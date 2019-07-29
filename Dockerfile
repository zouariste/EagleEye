FROM python:3-onbuild
COPY . /usr/src/app
CMD ["python", "TweetsProducer.py"]
CMD ["python", "Tweets_SentimentsAnalysis.py"]
