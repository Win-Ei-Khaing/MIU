import React, { useState } from 'react';
import { useEffect } from 'react';

import Post from '../../components/Post/Post';
import FullPost from '../../components/FullPost/FullPost';
import NewPost from '../../components/NewPost/NewPost';
import './Blog.css';
import axios from 'axios';
import { APIConfig } from '../../store/API-Config';

function Blog(){
    const [posts, setPosts] = useState([]);

    const [selectedId, setSelectedId] = useState(null);
    
    const [isLoading, setIsLoading] = useState(true);
     
    const base = 'http://localhost:8080';

    useEffect(() => {
        axios.get('http://localhost:8080/posts')
            .then(response => {
                /*const sposts = response.data.slice(0,5);  // This will get them but take the first 5 then you would have to change the response.data i nthe setPosts
                const updatedPosts = sposts.map(post => {  // This will transform anything before assigning it to the state
                    return {
                        ...post,
                        author: ' Dean'}
                });
                setPosts([...updatedPosts]);*/
                setPosts(response.data);   // if you dont want to limit
            })
            .then(setIsLoading(false))
            .catch(err => console.log("Retrieving POSTS failed => " + err.message));
    },[isLoading]);

    const postSelectedHandler = (id) => {
        setSelectedId(id);
    }

    // We can do this rather than this :: <Post title={{...posts[1]}.title} />
    const rposts = posts.map(post => {
        return <Post 
        key={post.id} 
        title={post.title} 
        author={post.author}
        clicked={() => {postSelectedHandler(post.id)}}/>
    });

    return (
        <APIConfig.Provider value={
            {
                postAPI: base + '/posts/'
            }
        }>
            <div>
                <section className="Posts">
                    {rposts}
                </section>
                <section>
                    <FullPost 
                    id={selectedId} 
                    title={posts
                        .filter(p=>p.id===selectedId)
                        .map(p=>p.title)}
                    body={posts
                        .filter(p=>p.id===selectedId)
                        .map(p=>p.author)}
                    done={()=>{ 
                        setSelectedId(null)
                        setIsLoading(true)
                        }}
                    /> 
                    
                </section>
                <section>
                    <NewPost submitted={()=>setIsLoading(true)}/>
                </section>
            </div>
        </APIConfig.Provider>
    );
}


export default Blog;