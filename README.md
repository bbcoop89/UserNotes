# UserNotes

CURL:

POST curl -X POST 
https://localhost:8444/notes 
-H 'authorization: Basic YnJpdHRhbnkucmV2ZXNAaWNsb3VkLmNvbTpwYXNzd29yZA==' 
-H 'cache-control: no-cache' 
-H 'content-type: application/json' 
-H 'postman-token: b23f72e2-5095-9a33-03b1-1cacebb7e34d' 
-d '{ "title": "Brittany'''s note", "note": "This is Brittany'''s Note" }'

GET curl -X GET 
https://localhost:8444/notes/2 
-H 'authorization: Basic YnJpdHRhbnkucmV2ZXNAaWNsb3VkLmNvbTpwYXNzd29yZA==' 
-H 'cache-control: no-cache' 
-H 'content-type: application/json' 
-H 'postman-token: 015c8e46-5faf-d5b1-566a-7b67ec7a43a7'

GET curl -X GET 
https://localhost:8444/notes 
-H 'authorization: Basic YnJpdHRhbnkucmV2ZXNAaWNsb3VkLmNvbTpwYXNzd29yZA==' 
-H 'cache-control: no-cache' 
-H 'content-type: application/json' 
-H 'postman-token: 6b93ab03-7ca3-42d7-ec3a-9ca419e71119'

DELETE curl -X DELETE 
https://localhost:8444/notes/2 
-H 'authorization: Basic YnJpdHRhbnkucmV2ZXNAaWNsb3VkLmNvbTpwYXNzd29yZA==' 
-H 'cache-control: no-cache' 
-H 'content-type: application/json' 
-H 'postman-token: 771d819d-bdfc-75e9-0245-bff8510dd8ba'

PUT curl -X PUT 
https://localhost:8444/notes 
-H 'authorization: Basic YW5vdGhlcl9ndXlAZ21haWwuY29tOnBhc3N3b3JkMQ==' 
-H 'cache-control: no-cache' 
-H 'content-type: application/json' 
-H 'postman-token: 664a2dc6-91a5-6ecd-51ca-20991eccadff' 
-d '{ "id": 4, "title": "Note 4 another guy edit again", "note": "Editing note number 4 again" }'
