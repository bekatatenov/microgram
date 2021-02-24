'use strict'

class User {
    constructor(id, login, email, name, password, posts, subers, subs, isAuthorised) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.posts = posts;
        this.subers = subers;
        this.subs = subs;
        this.isAuthorised = isAuthorised;
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
