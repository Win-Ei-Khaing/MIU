import axios from 'axios';
import React, { useContext, useState } from 'react';
import { APIConfig } from '../../store/API-Config';

import './NewPost.css';

function NewPost(props) {
    const APIs = useContext(APIConfig);
    const postAPI = APIs.postAPI;

    const[post, setPost]= useState({
        title: '',
        content: '',
        author: 'Dean'
    })
    const sendData= ()=>{
        axios.post(postAPI, post)
        .then(props.submitted)
    }

    return (
        <div className="NewPost">
            <h1>Add a Post</h1>
            <label>Title</label>
            <input type="text" onChange={(event) => setPost({...post, 'title': event.target.value})} />
            <label>Content</label>
            <textarea rows="4" onChange={(event) => setPost({...post, 'content': event.target.value})} />
            <label>Author</label>
            <select onChange={(event) => setPost({...post, 'author': event.target.value})}>
                <option value="Dean">Dean</option>
                <option value="Zaineh">Zaineh</option>
                <option value="Yasmeen">Yasmeen</option>
            </select>
            <button onClick={sendData}>Add Post</button>
        </div>
    );    
}

export default NewPost;