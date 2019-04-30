from flask import Flask, render_template
from flask_sockets import Sockets

# EB looks for an 'application' callable by default.
application = Flask(__name__)

sockets = Sockets(application)


# print a nice greeting.
@application.route('/')
def home():
    return render_template('index.html')


@sockets.route('/echo')
def echo_socket(ws):
    while not ws.closed:
        message = ws.receive()
        print(message)
        ws.send(message)


# run the app.
if __name__ == "__main__":
    # Setting debug to True enables debug output. This line should be
    # removed before deploying a production app.
    from gevent import pywsgi
    from geventwebsocket.handler import WebSocketHandler
    application.debug = True
    server = pywsgi.WSGIServer(('0.0.0.0', 5000), application, handler_class=WebSocketHandler)
    server.serve_forever()
