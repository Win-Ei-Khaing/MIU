import React from 'react';

import './NewPost.css';

const NewPost = () => {

        return (
            <div className="NewPost">
                <h1>Add a Post</h1>
                <label>Title</label>
                <input type="text"  />
                <label>Content</label>
                <textarea rows="4"  />
                <label>Author</label>
                <select >
                    <option value="Dean">Dean</option>
                    <option value="Zaineh">Zaineh</option>
                    <option value="Yasmeen">Yasmeen</option>
                </select>
                <button>Add Post</button>
            </div>
        );
 
}

export default NewPost;