# http://localhost:5000/requests?text=hello

from flask import Flask, redirect, url_for, request
app = Flask(__name__)

@app.route('/json-example', methods=['POST']) 
def json_example():
    req_data = request.get_json()
    print(req_data)
    return req_data
    


def translate(text):
   return text.upper()


@app.route('/success/<name>')
def success(name):
   return translate(name)

@app.route('/purchase_initiation', methods=['POST','GET'])
def initiation():
   retueredirect(url_for('requests',name = "requ"))
        

@app.route('/requests',methods = ['GET', 'POST'])
def requests():
   req_data = request.get_json()
   #language = req_data['text']
   #print(language)
    # ... do your business logic, and return some response
    # e.g. below we're just echo-ing back the received JSON data
      #return (data)
      #result=jsonify(request.json)
   #print (data.is_json)
   request_data = request.form.to_dict()
   print(request_data)
   content = request.get_json()
   print (content)
   print(type(request.args))
   user = request.args.get('text')
   return redirect(url_for('success',name = user))

if __name__ == '__main__':
   app.run(debug = True)

