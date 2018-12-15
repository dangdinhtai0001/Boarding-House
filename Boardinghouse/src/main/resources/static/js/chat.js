var database = firebase.database();
var $messages = $('.messages-content'),
    d, h, m,
    i = 0;

$(window).load(function () {
    $messages.mCustomScrollbar();
    setTimeout(function () {
        fakeMessage();
    }, 100);
});

function updateScrollbar() {
    $messages.mCustomScrollbar("update").mCustomScrollbar('scrollTo', 'bottom', {
        scrollInertia: 10,
        timeout: 0
    });
}

function setDate() {
    d = new Date();
    if (m != d.getMinutes()) {
        m = d.getMinutes();
        $('<div class="timestamp">' + d.getHours() + ':' + m + '</div>').appendTo($('.message:last'));
    }
}

function insertMessage() {
    msg = $('.message-input').val();
    if ($.trim(msg) == '') {
        return false;
    }
    $('<div class="message message-personal">' + msg + '</div>').appendTo($('.mCSB_container')).addClass('new');
    setDate();
    $('.message-input').val(null);
    updateScrollbar();
    setTimeout(function () {
        fakeMessage();
    }, 1000 + (Math.random() * 20) * 100);
}

$('.message-submit').click(function () {
    insertMessage();
});

$(window).on('keydown', function (e) {
    if (e.which == 13) {
        insertMessage();
        return false;
    }
});

var Fake = [
    'Hi there, I\'m Erza and you?',
    'Nice to meet you',
    'How are you?',
    'Not too bad, thanks',
    'What do you do?',
    'That\'s awesome',
    'Here is a nice place to stay',
    'I think you\'re a nice person',
    'Why do you think that?',
    'Can you explain?',
    'Anyway I\'ve gotta go now',
    'It was a pleasure chat with you',
    'Time to make a new awesome',
    'Bye',
    ':)'
];

function fakeMessage() {
    if ($('.message-input').val() != '') {
        return false;
    }
    $('<div class="message loading new"><figure class="avatar"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/156381/profile/profile-80.jpg" /></figure><span></span></div>').appendTo($('.mCSB_container'));
    updateScrollbar();

    setTimeout(function () {
        $('.message.loading').remove();
        $('<div class="message new"><figure class="avatar"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/156381/profile/profile-80.jpg" /></figure>' + Fake[i] + '</div>').appendTo($('.mCSB_container')).addClass('new');
        setDate();
        updateScrollbar();
        i++;
    }, 1000 + (Math.random() * 20) * 100);

}

$('#chat-header').on('click', function () {
    console.log("clicked");
    $('.chat').slideToggle(300, 'swing');
    $('.chat-message-counter').fadeToggle(300, 'swing');
});


// function toggleSignIn() {
//   if (!firebase.auth().currentUser) {
//     console.log("!");
//     // [START createprovider]
//     var provider = new firebase.auth.FacebookAuthProvider();
//     // [END createprovider]
//     // [START addscopes]
//     // [END addscopes]
//     // [START signin]
//     firebase.auth().signInWithPopup(provider).then(function(result) {
//       // This gives you a Facebook Access Token. You can use it to access the Facebook API.
//       var token = result.credential.accessToken;
//       // The signed-in user info.
//       var user = result.user;
//       // [START_EXCLUDE]
//       document.getElementById('quickstart-oauthtoken').textContent = token;
//       // [END_EXCLUDE]
//     }).catch(function(error) {
//       // Handle Errors here.
//       var errorCode = error.code;
//       var errorMessage = error.message;
//       // The email of the user's account used.
//       var email = error.email;
//       // The firebase.auth.AuthCredential type that was used.
//       var credential = error.credential;
//       // [START_EXCLUDE]
//       if (errorCode === 'auth/account-exists-with-different-credential') {
//         alert('You have already signed up with a different auth provider for that email.');
//         // If you are using multiple auth providers on your app you should handle linking
//         // the user's accounts here.
//       } else {
//         console.error(error);
//       }
//       // [END_EXCLUDE]
//     });
//     // [END signin]
//     console.log(provider);
//   } else {
//     console.log(" - ");
//       // [START signout]
//       firebase.auth().signOut();
//       // [END signout]
//   }
//     // [START_EXCLUDE]
//     // document.getElementById('btnFaceBook').disabled = true;
//     // [END_EXCLUDE]
// }
