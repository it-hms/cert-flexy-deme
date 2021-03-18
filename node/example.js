const express = require('express')
const app = express()
const port = 8080

app.use(express.json())

app.post('/', (req,res) => {
        console.log(req.headers)
        console.log(req.body)
        res.send("{ \"response\": \"works\" }")
})


app.get('/', (req,res) => {
        res.send("<h1> test server </h1>")
})


app.listen(port, ()=>{
        console.log('Example app running')
})