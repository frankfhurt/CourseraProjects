var cores = ["amarelo", "azul", "branco", "cinza", "laranjado", "roxo", "preto"]
var corPensada = cores[Math.floor((Math.random() * cores.length) + 1)];
var corDigitada;

if (![].contains) {
	Object.defineProperty(Array.prototype, 'contains', {
		enumerable: false,
		configurable: true,
		writable: true,
		value: function(searchElement/*, fromIndex*/) {
			if (this === undefined || this === null) {
				throw new TypeError('Cannot convert this value to object');
			}
			var O = Object(this);
			var len = parseInt(O.length) || 0;
			if (len === 0) { return false; }
			var n = parseInt(arguments[1]) || 0;
			if (n >= len) { return false; }
			var k;
			if (n >= 0) {
				k = n;
			} else {
				k = len + n;
				if (k < 0) k = 0;
			}
			while (k < len) {
				var currentElement = O[k];
				if (searchElement === currentElement ||
					searchElement !== searchElement && currentElement !== currentElement
					) {
					return true;
			}
			k++;
		}
		return false;
	}
});
}

function fazerPergunta() {
	// alert("Cor pensada: " + corPensada);

	corDigitada = prompt("Eu estou pensando em uma dessas cores:\n\n" 
		+ cores
		+ "\n\nEm que Cor estou pensando?"
		);

	avaliarResposta();
}

function avaliarResposta() {
	if (corPensada == corDigitada)
		darParabens();
	else if (cores.contains(corDigitada))
		darDicaEPerguntarNovamente();
	else
		mostrarErroEPerguntarNovamente();
}

function darParabens() {
	alert("Parabéns!\nVocê acertou a resposta!\nEu estava pensando justamente na cor: " + corPensada);
}

function darDicaEPerguntarNovamente() {
	var indexCorPensada = cores.indexOf(corPensada);
	var indexCorDigitada = cores.indexOf(corDigitada);

	if (indexCorPensada > indexCorDigitada)
		alert("A cor que estou pensando é alfabéticamente MAIOR do que a digitada!");
	else
		alert("A cor que estou pensando é alfabéticamente MENOR do que a digitada!");

	fazerPergunta();
}

function mostrarErroEPerguntarNovamente() {
	alert("A palavra digitada não corresponde à uma cor da lista!\nTente Novamente!");
	fazerPergunta();
}