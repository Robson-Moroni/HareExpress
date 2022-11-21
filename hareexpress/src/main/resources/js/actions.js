

function post(url, data, callBack){

    $.ajax({
         method:"POST",
         url: url,
         data: data,
    })

}

 function save(){
    let form = document.getElementById("form");
    var formData = new FormData(form);
    var url = "/" + form.name + "/create"

    post(url,formData, "");

 }

  function exclude(){

  }

  function update(){

   }

  function findById(){

    }

  function list(){

    }