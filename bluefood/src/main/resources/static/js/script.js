//Função para chamar números e outras teclas como shift...
// chamado ao pressionar a tecla "onkeydown"
function isNumberKey(evt){
    //identificando o navegador e suas propriedades
    var charCode = (evt.which) ? evt.which : evt.keyCode

    //Verificando pela tabela ASCII as teclas possíveis para ser digitado
    if((charCode >= 48 && charCode <= 57) || charCode <= 31 || charCode >= 96 && charCode <= 105){
        return true;
    }

    return false;
}