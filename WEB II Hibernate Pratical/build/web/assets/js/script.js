const rootPath = window.location.origin + window.location.pathname;

function createNewAccount() {

    const fname = document.getElementById("fname").value;
    const lname = document.getElementById("lname").value;
    const email = document.getElementById("email").value;

    const studentData = {

        firstName: fname,
        lastName: lname,
        email: email

    };
    const studentJSON = JSON.stringify(studentData);

    const ajax = new XMLHttpRequest();

    ajax.open("POST", rootPath + "StudentController", true);

    ajax.onreadystatechange = function () {

        if (ajax.readyState === 4) {

            if (ajax.status === 200) {

                alert(ajax.responseText);

            } else {

                alert("Data inserting failed!");

            }

        }

    };

    ajax.send(studentJSON);
}

function updateStudent() {
    
    const updateData = {
        id: 1,
        firstName: "Prageeth",
        lastName: "Perera",
        email: "prageeth@gmail.com",
        studentClassId: 2
    };
    
    const updateJSON = JSON.stringify(updateData);
    
    const ajax = new XMLHttpRequest();
    
    ajax.open("PUT", rootPath + "StudentController", true);
    
    ajax.onreadystatechange = function () {
        
        if (ajax.readyState === 4) {
            
            if (ajax.status === 200) {
                
                console.log(ajax.responseText);
                
            } else {
                
                alert("Data updating failed!");
                
            }
            
        }
        
    };
    
    ajax.send(updateJSON);
    
}

function updateStudent() {

    const ajax = new XMLHttpRequest();
    
    ajax.open("DELETE", rootPath + "StudentController?id=2", true);
    
    ajax.onreadystatechange = function () {
        
        if (ajax.readyState === 4) {
            
            if (ajax.status === 200) {
                
                console.log(ajax.responseText);
                
            } else {
                
                alert("Data updating failed!");
                
            }
            
        }
        
    };
    
    ajax.send();
    
}

function searchStudentData() {
    
    const ajax = new XMLHttpRequest();
    
    ajax.open("GET", rootPath + "StudentController?action=getAll", true);
    
    ajax.onreadystatechange = function () {
        
        if (ajax.readyState === 4) {
            
            if (ajax.status === 200) {
                
                console.log(ajax.responseText);
                
            } else {
                
                alert("Data searching failed");
                
            }
            
        }
        
    };
    
    ajax.send();
        
}
