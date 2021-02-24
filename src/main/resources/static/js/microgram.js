'use strict'

class User {
    constructor(id, login, email, name, password, posts, subers, subs, isAuthorized) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.posts = posts;
        this.subers = subers;
        this.subs = subs;
        this.isAuthorised = isAuthorized;
    }

}

class Post {
    constructor(id, pathOfImage, text, date, user, likes, comments) {
        this.id = id;
        this.pathOfImage = pathOfImage;
        this.text = text;
        this.date = date;
        this.user = user;
        this.likes = likes;
        this.comment = comments;
    }
}

class Comment {
    constructor(id, post, text, data, user) {
        this.id = id;
        this.post = post;
        this.text = text;
        this.date = data;
        this.user = user;
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

function addPostToArrayPosts(post) {
    posts.push(post);
}

function isUserAuth(user) {
    return user.isAuthorized;
}

function changeAuthOfUser(user) {
    user.isAuthorized = !user.isAuthorized;
}