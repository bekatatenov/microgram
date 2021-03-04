'use strict'

const BASE_URL = 'http://localhost:9999';

// localStorage.removeItem('user');

class User {
    id;
    name;
    username;
    email;

    constructor(id, name, username, email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }
}

class Post {
    constructor(id, pathOfImage, text, title, userId) {
        this.id = id;
        this.pathOfImage = pathOfImage;
        this.text = text;
        this.title = title;
        this.userId = userId;
    }
}

class Comment {

    postId;
    id;
    email;
    body;

    constructor(id, postId, email, body) {
        this.postId = postId;
        this.id = id;
        this.email = email;
        this.body = body;
    }
}

class Like {
    constructor(id, post, user, date) {
        this.id = id;
        this.post = post;
        this.user = user;
        this.date = date;
    }
}

let posts = [];
let users = [];
let urlImages = [];
let comments = [];


function createUrlImages(json) {
    urlImages.push(json.url);
}

function createPostFromJson(json) {
    var post = new Post(json.id, urlImages[posts.length + 1], json.body, json.title, json.userId)
    posts.push(post);
}

function createUserFromJson(json) {
    var user = new User(json.id, json.name, json.username, json.email);
    users.push(user);
}


async function getPosts() {
    let data = await fetch('https://jsonplaceholder.typicode.com/posts')
        .then((response) => response.json());
    return data;
}

async function getPhotos() {
    let data = await fetch(('https://jsonplaceholder.typicode.com/photos'))
        .then((response) => response.json());
    return data;
}

async function getUsers() {
    let data = await fetch(('https://jsonplaceholder.typicode.com/users'))
        .then((response) => response.json());
    return data;
}

async function getComments() {
    let data = await fetch(('https://jsonplaceholder.typicode.com/comments'))
        .then((response) => response.json());
    return data;
}

function isUserAuth(user) {
    return user.isAuthorized;
}

function changeAuthOfUser(user) {
    user.isAuthorized = !user.isAuthorized;
}

function showSplashScreen() {
    localStorage.removeItem('user');
    document.getElementsByClassName('outOfUser')[0].remove();
    document.getElementById('splash').hidden = false;
    document.body.classList.add("scroll");
}

function hideSplashScreen() {
    document.getElementById("splash").hidden = true;
    document.body.classList.remove("scroll");
}

function createCommentElement(comment) {
    let newComment = document.createElement('li');
    newComment.innerHTML = ` <li>
        <span style="font-weight: bold">${comment.email}:</span> ${comment.body}
    </li>`;
    return newComment;
}

function createLogOutHeader(user) {
    let newli = document.createElement('ul');
    newli.setAttribute('class', 'outOfUser');
    newli.innerHTML = ` <li>
                        <p>${user.username}</p>
                    </li>
                     <li class="nav-item">
                        <button class="btn btn-dark" style="padding: 0; margin: 0" onclick="showSplashScreen()">
                            Log Out
                        </button>
                    </li>`;
    var old = document.getElementsByClassName('headerIcons')[0];
    old.prepend(newli);
}


function findByUserById(userId) {

    let user;

    for (let i = 0; i < users.length; i++) {
        if (users[i].id === userId) {
            user = users[i];
        }
    }
    return user;
}

function commentsFindPostId(postId) {
    let com = document.createElement('div');
    for (let i = 0; i < comments.length; i++) {
        if (comments[i].postId == postId) {
            com.append(createCommentElement(comments[i]));
        }
    }
    return com;
}

function createPostElement(post) {

    var user = findByUserById(post.userId);
    var com = commentsFindPostId(post.id);

    let newPost = document.createElement('div');
    newPost.innerHTML = `
        <div class="post post-container" id="${post.id}">
            <div class="post-header">

                <img src="images/avatar.jpg" class="user-avatar" alt="Avatar of User"/>
                <div class="user-info">
                    <span class="post-author">${user.name}</span>
                    <span class="photo-location">SomeWhere</span>
                </div>

            </div>

            <div class="post-image">
                <div class="likeOnImage" hidden><i class="fas fa-heart" style="color: red"></i></div>
                <img src=${post.pathOfImage} alt="postPhoto" width="700" height="700">
            </div>
            <div class="post-footer">
                <i class="far fa-heart post-heart under_post_footer"></i>
                <i class="far fa-comment under_post_footer"></i>
                <i class="far fa-paper-plane under_post_footer"></i>
                <i class="far fa-bookmark save under_post_footer"></i>
            </div>

            <div class="post-desc">
                <p><span style="font-weight: bold"> ${user.name}: </span> ${post.text}</p>
            </div>

            <div class="post-comments" hidden>
            
            </div>
            <div class="new-comment-form" hidden>
                <form>
                    <label>
                        <input class="newComment" placeholder="new Comment" type="text"
                               name="newComment">
                    </label>
                    <div>
                        <input type="hidden" name="idUser" value="${user.id}}">
                    </div>
                    <div>
                        <input type="hidden" name="idPost" value="${post.id}}">
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
            </div>

        </div>
`;

    return newPost;
}

function showAllPosts() {
    for (let i = 0; i < posts.length; i++) {
        document.getElementsByClassName('posts')[0].prepend(createPostElement(posts[i]))
    }
}

function elemForLogOut(user) {

}


function addPost(postElement) {
    document.getElementsByClassName('posts').prepend(postElement);
}

if (localStorage.getItem('user')) {
    createLogOutHeader(restoreUser());
    hideSplashScreen();
}


getPosts().then(postsJson => {
    getPhotos().then(imagesJson => {
        getUsers().then(usersJson => {

            let arrayUsers = usersJson;
            let arrayImages = imagesJson;
            let arrayPosts = postsJson;


            for (let i = 0; i < arrayUsers.length; i++) {
                users.push(new User(arrayUsers[i].id, arrayUsers[i].name, arrayUsers[i].username, arrayUsers[i].email))
            }
            for (let i = 0; i < arrayImages.length; i++) {
                urlImages.push(arrayImages[i].url)
            }
            for (let i = 0; i < arrayPosts.length; i++) {
                posts.push(new Post(arrayPosts[i].id, urlImages[i + 1], arrayPosts[i].body, arrayPosts[i].title, arrayPosts[i].userId))
            }

            console.log(posts.length);

            showAllPosts();
            listeners()
        });
    });
});


function saveUser(user) {
    const userAsJSON = JSON.stringify(user)
    createLogOutHeader(user);
    localStorage.setItem('user', userAsJSON);
}

function restoreUser() {
    const userAsJSON = localStorage.getItem('user');
    const user = JSON.parse(userAsJSON);
    return user;
}

function updateOptions(options) {
    const update = {...options};
    update.mode = 'cors';
    update.headers = {...options.headers};
    update.headers['Content-Type'] = 'application/json';
    const user = restoreUser();
    if (user) {
        update.headers['Authorization'] = 'Basic ' + btoa(user.username + ':' + user.password);
    }
    return update;
}

function fetchAuthorised(url, options) {
    const settings = options || {}
    return fetch(url, updateOptions(settings));
}


const loginForm = document.getElementById('login-form');
loginForm.addEventListener('submit', onLoginHandler);

function onLoginHandler(e) {
    e.preventDefault();
    const form = e.target;
    const userFormData = new FormData(form);
    const user = Object.fromEntries(userFormData);
    saveUser(user);
    hideSplashScreen();
    // fetchAuthorised(BASE_URL+'posts')
}

// EventListeners
function listeners() {

    let heartsFromFront = document.getElementsByClassName('fa-heart');
    let bookmarkFromFront = document.getElementsByClassName('fa-bookmark');

    function changeLike(heart) {
        if (heart.classList.contains('far')) {
            heart.classList.remove('far');
            heart.classList.add('fas');
            heart.setAttribute('style', 'color:red;')
        } else {
            heart.classList.remove('fas');
            heart.classList.add('far');
            heart.removeAttribute('style');
        }
    }

    function changeBookmark(bookmark) {
        if (bookmark.classList.contains('far')) {
            bookmark.classList.remove('far');
            bookmark.classList.add('fas');
        } else {
            bookmark.classList.remove('fas');
            bookmark.classList.add('far');
        }
    }

    for (let i = 1; i < heartsFromFront.length; i++) {
        heartsFromFront[i].addEventListener('click', function () {
            changeLike(heartsFromFront[i])
        });
    }
    for (let i = 0; i < bookmarkFromFront.length; i++) {
        bookmarkFromFront[i].addEventListener('click', function () {
            changeBookmark(bookmarkFromFront[i]);
        });
    }

    let imagesFromFront = document.getElementsByClassName('post-image');

    for (let i = 0; i < imagesFromFront.length; i++) {
        imagesFromFront[i].addEventListener('dblclick', function () {

            var firstElementChild = imagesFromFront[i].nextElementSibling.firstElementChild;

            changeLike(firstElementChild);
            document.getElementsByClassName('likeOnImage')[i].hidden = false;
            setTimeout(() => {
                document.getElementsByClassName("likeOnImage")[i].hidden = true;
            }, 1000)
        })
    }
    let commentFromFront = document.getElementsByClassName('fa-comment');
    let newCommentFromFront = document.getElementsByClassName('new-comment-form');
    let commentsShow = document.getElementsByClassName('post-comments');

    for (let i = 0; i < commentFromFront.length; i++) {
        commentFromFront[i].addEventListener('click', function () {

            commentsShow[i].innerHTML = " ";
            if (newCommentFromFront[i].hidden === false) {
                commentsShow[i].hidden = true;
                newCommentFromFront[i].hidden = true;
                comments = [];

            } else {
                commentsShow[i].hidden = false;
                newCommentFromFront[i].hidden = false;
                getComments().then(result => {
                    let arrayComments = result;

                    for (let i = 0; i < arrayComments.length; i++) {
                        comments.push(new Comment(arrayComments[i].id, arrayComments[i].postId, arrayComments[i].email, arrayComments[i].body));
                    }
                    let postId = commentFromFront[i].parentElement.parentElement.getAttribute("id");
                    var htmlDivElement = commentsFindPostId(postId);
                    commentsShow[i].append(htmlDivElement);

                });
            }
        })
    }
}


// function fromResourceToObject(object) {
//     var id = object.id;
//     var title = object.title;
//     var text = object.body;
//     var userId = object.userId;
//
//     var newPost = new Post(id, ololo, text, date.now, userId);
//     posts.push(newPost);
// }
//
// let countOfPosts = 100;
//
// for (let i = 0; i < countOfPosts; i++) {
//     fetch('https://jsonplaceholder.typicode.com/posts/' + i)
//         .then((response) => response.json())
//         .then((json) => fromResourceToObject(json));
// }


// const newPostForm = document.getElementById("newPostId");
//
// async function newPostHandler(e) {
//     e.preventDefault();
//     const form = e.target;
//     const data = new FormData(form);
//     await fetch('http://127.0.0.1:9999/posts', {
//         method: 'POST',
//         body: data
//     });
// }
//
// newPostForm.addEventListener('submit', newPostHandler);
//
//
// async function newCommentHandler(e) {
//     e.preventDefault();
//     const form = e.target;
//     const data = new FormData(form);
//     await fetch('http://127.0.0.1:9999/comments/' + postid, {
//         method: 'POST',
//         body: data
//     });
// }