
// Função para envio do formulário para a API somente após a validação do formulário
function enviarFormulario() {

  var formularioValido = validarFormulario()

  if (formularioValido) {

    // endpoint da API
    var url = "localhost:8080/cadastro";

    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    xhr.onreadystatechange = function() { // Chama a função quando o estado mudar.
      if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        console.log("Envio POST para API ocorreu com sucesso.");
        alert("Dados enviados com sucesso!");
      } else {
        console.error("Erro no envio POST para API. Código de status HTTP: " + xhr.status);
        alert("Erro ao enviar os dados para API")
      }
    }

    // obtendo os valores do formulario
    var cliente = {
      nome: document.getElementById("nome").value,
      sobrenome: document.getElementById("sobrenome").value,
      linkedin: document.getElementById("linkedin").value,
      whatsapp: document.getElementById("whatsapp").value,
      discord: document.getElementById("discord").value,
      email: document.getElementById("email").value,
      github: document.getElementById("github").value,
      perfil: document.getElementById("perfil").value,
      area: document.getElementById("area").value,
      senha: document.getElementById("senha").value
    };

    // serializar os dados do formulário em um objeto JSON
    var dadosJson = JSON.stringify(cliente);
    // enviar os dados do formulário via requisição POST		      
    xhr.send(dadosJson);
    // Impede o comportamento padrão do formulário de atualizar a página, o que não permite que os dados já escritos no formulário sejam apagados
    return false;
  }

  // Impede o comportamento padrão do formulário de atualizar a página, o que não permite que os dados já escritos no formulário sejam apagados
  return false;

}




// Função para validar o formulário informado pelo usuário
function validarFormulario() {

  // Validar campos obrigatórios
  var nome = document.getElementById("nome").value;
  var sobrenome = document.getElementById("sobrenome").value;
  var email = document.getElementById("email").value;
  var senha = document.getElementById("senha").value;
  var confirmarSenha = document.getElementById("confirmarSenha").value;

  if (nome == "" || sobrenome == "" || email == "" || senha == "" || confirmarSenha == "") {
    alert("Por favor, preencha todos os campos obrigatórios (nome, sobrenome, email, senha e confirmação de senha!");
    return false;
  }


  // Validar senha
  var regexSenha = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,12}$/;
  if (!regexSenha.test(senha)) {
    alert("A senha deve ter entre 6 a 12 caracteres e conter pelo menos um número, uma letra maiúscula e uma letra minúscula.");
    return false;
  }
  

  // Confirmação de senha
  if (senha !== confirmarSenha) {
    alert("As senhas não correspondem.");
    return false;
  }

  return true;

}




// Exigir que o usuário leia os termos de uso e a política de privacidade antes de ativar o botão "Criar minha conta".
var termosLidos = false;
var politicaLida = false;

function verificarHabilitarBotao() {
    var botao = document.getElementById("criarConta");

    if (termosLidos && politicaLida) {
        botao.disabled = false;
    } else {
        botao.disabled = true;
    }
}

function marcarTermosLidos() {
    termosLidos = true;
    verificarHabilitarBotao();
}

function marcarPoliticaLida() {
    politicaLida = true;
    verificarHabilitarBotao();
}





// Função para fechar e abrir o olho mágico

function togglePasswordVisibility() {
  var passwordInput = document.getElementById("senha");
  var toggleIcon = document.querySelector(".toggle-password");

  if (passwordInput.type === "password") {
    passwordInput.type = "text";
    toggleIcon.classList.add("open-eye");
    toggleIcon.classList.remove("closed-eye");
  } else {
    passwordInput.type = "password";
    toggleIcon.classList.add("closed-eye");
    toggleIcon.classList.remove("open-eye");
  }
}



