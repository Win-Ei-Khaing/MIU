import React from 'react';
import axios from 'axios';

import './FullPost.css';

function FullPost(props){
        //console.log(props);
        const deletePost=()=>{
            axios.delete("http://localhost:8080/posts/"+props.id)
            //.then(console.log("Successfully deleted"))
            .then(props.done)
            .catch(err=>"Deletion failed "+err.message)
        }

        let post = <p>Please select a Post!</p>;
        if(props.id !=null){
            post = (
                <div className="FullPost">
                    <h1>{props.title}</h1>
                    <p>{props.body}</p>
                    <div className="Edit">
                        <button className="Delete" onClick={deletePost}>Delete</button>
                    </div>
                </div>
                 );
        }
        return post;
    }

export default FullPost;