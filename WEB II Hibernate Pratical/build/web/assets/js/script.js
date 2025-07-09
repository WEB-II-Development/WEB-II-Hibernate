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