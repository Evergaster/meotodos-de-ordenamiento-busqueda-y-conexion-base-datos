from firebase_admin import credentials, db
import firebase_admin

cred = credentials.Certificate("code/conexionFirebase/credenciales.json")
firebase_admin.initialize_app(cred, {
    'databaseURL': 'https://proyecto-iot-2021-default-rtdb.firebaseio.com/'
})


ref = db.reference('/')
print(ref.get())