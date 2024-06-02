var swiper = new Swiper(".mySwiper", {
  slidesPerView: 1,
  freeMode: true,
  loop: true,
  autoplay: {
    enable: true,
    delay: 3000
  },
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  },
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
});


function inviaPaginaDisponibilita() {

  let filtri = document.querySelectorAll('.filtro');
  console.log(filtri);
  filtri.forEach(btn => {
    btn.addEventListener('click', function () {
      const id = btn.getAttribute('data-id');
      const nome = btn.getAttribute('data-nome');
      console.log(id);
      console.log(nome);
      localStorage.setItem('id', JSON.stringify(id));
      localStorage.setItem('nome', JSON.stringify(nome));
      window.location.href = 'disponibilita.html';
    });
  });
}
inviaPaginaDisponibilita();

let user = document.querySelector('.user');
let carrello = document.querySelector('.carrello');
let logout = document.querySelector('.logout');
let login = document.querySelector('.login');
let admin = document.querySelector('.admin');

function logged() {

  let getIdUtente = localStorage.getItem('idUtente');

  if (getIdUtente != null) {
    console.log(getIdUtente);
    user.classList.remove('d-none');
    user.classList.add('d-block');
    carrello.classList.remove('d-none');
    carrello.classList.add('d-block');
    logout.classList.remove('d-none');
    logout.classList.add('d-block');
    login.classList.add('d-none');

  } else {
    console.log(55);
    user.classList.add('d-none');
    carrello.classList.add('d-none');
    logout.classList.add('d-none');
    login.classList.remove('d-none');
    login.classList.add('d-block');
  }

}


function logOut() {
  localStorage.removeItem('idUtente');
  localStorage.removeItem('arrayIdOggetto');
  localStorage.removeItem('arrayId');
  localStorage.removeItem('totaleCarrello');
  
  let ruolo = localStorage.getItem('ruolo');
  console.log(ruolo);
  if (ruolo === "USER") {
    console.log('si');
    logged();
  } else if (ruolo === "ADMIN") {
    loggedAdmin();
  }
  localStorage.removeItem('ruolo');
}

logout.addEventListener('click', logOut);

let arrayCarrello = [];
let numeroArticoli = document.querySelector('#numeroArticoli');
let numProdotti = 0;

function contoCarrello() {
  console.log(numProdotti);

  arrayCarrello = JSON.parse(localStorage.getItem('arrayId'));
  console.log(arrayCarrello);

  if (arrayCarrello !== null) {

    numProdotti = arrayCarrello.length;
  }
  console.log(numProdotti);
  numeroArticoli.innerHTML = numProdotti;

  if (numProdotti == 0) {
    numeroArticoli.innerHTML = null;
  }

}
contoCarrello();

let ruolo = "";

function ottieniRuolo() {

  let idUtente = localStorage.getItem('idUtente');

  if (idUtente !== null) {

    fetch(`http://localhost:8080/api/utenti/${idUtente}`)
      .then((res) => res.json())
      .then((data) => {
        console.log(data.ruolo);

        ruolo = data.ruolo;
        localStorage.setItem('ruolo', ruolo);


        console.log(ruolo);
        let ruoloLocale = localStorage.getItem('ruolo');
        if (ruoloLocale === "USER") {
          console.log('si');
          logged();
        } else if (ruoloLocale === "ADMIN") {
          loggedAdmin();
        }
      });
  }

}
ottieniRuolo();

function loggedAdmin() {
  let getIdUtente = localStorage.getItem('idUtente');

  if (getIdUtente != null) {
    console.log(getIdUtente);
    user.classList.remove('d-none');
    user.classList.add('d-block');
    admin.classList.remove('d-none');
    admin.classList.add('d-block');
    logout.classList.remove('d-none');
    logout.classList.add('d-block');
    login.classList.add('d-none');

  } else {
    console.log(55);
    user.classList.add('d-none');
    logout.classList.add('d-none');
    admin.classList.add('d-none');
    login.classList.remove('d-none');
    login.classList.add('d-block');
  }

}