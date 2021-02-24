'use strict';

class User {
    constructor(id, name, email, password, isAuthorised) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAuthorised = isAuthorised;
    }
};

class Post {
    constructor(id, text, image, date, user) {
        this.id = id;
        this.text = text;
        this.image = image;
        this.date = date;
        this.user = user;
    }
};

class Comment {
    constructor(id, text, date, user) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.user = user;
    }
};

const user = new User(1, "Anako", "bekatatenov@gmail.com", "lol", true);
const post = new Post(1, "My first pic", "image/img.jpg", "01.01.2020", user.id, false);
// const comment = new Comment(1, "Kamil is a great support", "12-12-2020", user.id, post.id);

authorise(user);
let posts = [];
let comments = [];

function addPostToArray(post) {
    posts.push(post);
}

function authorise(user) {
    user.isAuthorised = !user.isAuthorised;
}

function likeToPost(postId) {
    for (let i = 0; i < posts.length; i++) {
        if (postId === posts[i].id) {
            posts[i].like = !posts[i].like;
        }
    }
}

function showSplashScreen() {
    document.getElementById("splash").hidden = false;
    document.body.classList.add("scroll");
}

function hideSplashScreen() {
    document.getElementById("splash").hidden = true;
    document.body.classList.remove("scroll");
}

function createCommentElement(comment) {
    var com = document.getElementById("newComment").value;
    let newComment = document.createElement('li');
    newComment.innerHTML = `<li class="photo__comment">
                    <span class="photo__comment-author">${comment.user.name}    </span>${comment.text}
                </li>`;
    return newComment;
}

function addComment(commentElement) {
    let inIT = document.getElementById("comment");
    inIT.appendChild(commentElement);
}

function addCom() {
    const comment = new Comment(1, document.getElementById("newComment").value, Date.now(), user);
    comments.push(comment);
    const commentElement = createCommentElement(comment);
    addComment(commentElement);
}

function addPos() {

    const form = document.getElementsByClassName("postAddingForm")[0];
    const elements = form.elements;

    let post = new Post("1", elements['desc'].value, "./images/newPost.jpg", Date.now(), user);
    posts.push(post);
    const postElem = createPostElement(post);
    addPost(postElem);

}

function changeStatusLike(heart) {
    if (heart.classList.contains('far')) {
        heart.classList.remove('far');
        heart.classList.add('fas');
        heart.classList.add('colorForHeart')
    } else {
        heart.classList.remove('fas');
        heart.classList.add('far');
        heart.classList.remove('colorForHeart');
    }
}

function addCommentHtml() {

    document.getElementsByClassName('po')


    if (comment.classList.contains('unshow')) {
        comment.classList.remove('unshow')
    } else {
        comment.classList.add('unshow');
    }
}

function addEventForHeart() {
    let listOfHearts = document.getElementsByClassName('heartss');
    let newHeart = listOfHearts[listOfHearts.length - 1];
    newHeart.addEventListener('click', function () {
        changeStatusLike(newHeart)
    });
}

function addEventForImage() {
    let list = document.getElementsByClassName('postImage');
    let newOne = list[list.length - 1];
    newOne.addEventListener("dblclick", function () {

        changeStatusLike(like)

        let gif = document.createElement('div');
        gif.classList.add("gif");
        gif.innerHTML = `<i class="fas fa-heart" style="color: red"></i>`;
        newOne.append(gif);
        setTimeout(function () {
            gif.style.display = 'none';
        }, 1000);

    });
}

function newEvents() {
    var main = document.getElementsByClassName('postsss');


}


function addPost(postElem) {
    let inIT = document.getElementById("posts");
    inIT.appendChild(postElem);
    newEvents();
}

function createPostElement(post) {
    var newPostHtml = document.createElement('div')
    let cls = document.createAttribute("class");
    cls.value = "postContr post";
    let id = document.createAttribute("id");
    id.value = "post";
    newPostHtml.setAttributeNode(cls);
    newPostHtml.setAttributeNode(id);
    newPostHtml.innerHTML = `
            <div class="posHeader photo photo__header">
                <img src="./images/avatar.jpg" class="photo__avatar" alt="Avatar of User"/>
                <div class="photo__user-info">
                    <span class="photo__author">${post.user.name}</span>
                    <span class="photo__location">${post.text}</span>
                </div>
            </div>

            <div class="postPhoto">
                 <img src=${post.image} alt="postPhoto" width="690" height="700">
            </div>
           
            <div class="postBody">

                <i class="far fa-heart heartss underPhoto"></i>
                <i class="far fa-comment underPhoto"></i>
                <i class="far fa-paper-plane underPhoto "></i>
                <i class="far fa-bookmark savePost underPhoto"></i>

            </div>
           
            <div>
                <p style="padding: 10px">Likes <span style="font-weight: bold"><a style="text-decoration: none"
                                                                                  href="https://www.instagram.com/zuck/?hl=ru">Zuck</a> and others </span>
                </p>
            </div>
            <div class="desc">
            Desc: ${post.text}
</div>
            <div>
                <ul id="comment" class="photo__comments">
                </ul>

            </div>
      
            <div class="postFooter">
                <form><label>
                    <input id="newComment" class="newComment" placeholder="new Comment" type="text" name="newComment">
                </label>
                    <label>
                        <input class="buttonComment" value="Comment" onclick="addCom()">
                    </label>
                </form>
            </div>`;

    return newPostHtml;
}

function startNewFor() {

    let likesFromFront = document.getElementsByClassName('heartss');

    let postsFromFront = document.getElementsByClassName('postContr');

    let bookmakerFromFront = document.getElementsByClassName('fa-bookmark');

    let commentFromFront = document.getElementsByClassName('fa-comment');

    for (let i = 0; i < bookmakerFromFront.length; i++) {
        bookmakerFromFront[i].addEventListener('click', function () {
            changeStatusLike(bookmakerFromFront[i])
        })
    }


    for (let i = 0; i < commentFromFront.length; i++) {
        commentFromFront[i].addEventListener('click', function () {
            if (document.getElementsByClassName('unshow').length === 1) {
                changeStatusLike(commentFromFront[i])
            }
        });
    }

    for (let i = 0; i < likesFromFront.length; i++) {
        likesFromFront[i].addEventListener('click', function () {
            changeStatusLike(likesFromFront[i])
        });
    }

    for (let i = 0; i < postsFromFront.length; i++) {
        let postPhotos = postsFromFront[i].getElementsByClassName('postPhoto');
        let like = postsFromFront[i].getElementsByClassName('heartss')[0];

        for (let j = 0; j < postPhotos.length; j++) {
            postPhotos[j].addEventListener("dblclick", function () {
                changeStatusLike(like)

                let gif = document.createElement('div');
                gif.classList.add("gif");
                gif.innerHTML = `<i class="fas fa-heart" style="color: red"></i>`;
                postPhotos[j].append(gif);
                setTimeout(function () {
                    gif.style.display = 'none';
                }, 1000);

            });

        }
    }
}

startNewFor();

const newPostForm = document.getElementById("newPostId");

async function newPostHandler(e) {
    e.preventDefault();
    const form = e.target;
    addPos();
    const data = new FormData(form);
    await fetch('http://127.0.0.1:9999/posts', {
        method: 'POST',
        body: data
    });
}

newPostForm.addEventListener('submit', newPostHandler);