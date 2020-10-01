var quotes = ["My liver is available - Lolontle Moatshe","It's time for an Activation - Tshepang Badimo", "Ha ke nwe tempreture, ke nwa alcohol! - Khumo Ntlamelle", "Not when you're me. Normally, yes. For average people, yes. Their dicks would fall off but not me im a stallion, this is my thing. - Sanele Nakadi", "Monna, a mess is me. It's a wow! - Lesedi Gaetsewe", "Mokolobete - Mpho Gaetswe", "E ntira Va Va Voom - Lorato Moatshe", "O laola ka re ke ene School Governing Body - Charity Samogelo Balepile", "You think my liver is a theme park - Ketumetse Leketi", "Ke rata di Buns - Lufuno Mathivha" ]

function newQuote() {
  	var randomInt = Math.floor(Math.random() * quotes.length);

	var arr = quotes[randomInt].split('-');
  	document.getElementById('text').innerHTML = arr[0];
  	document.getElementById('author').innerHTML = "-" + arr[1];
}