
let arrAges = [];

function addStudent () {


    const studentsTable = document.getElementById("studentsTable").getElementsByTagName("tbody")[0];

    let studentName = document.getElementById("studentName").value;

    let birthDate = document.getElementById("birthDate").value;

    let gender = document.getElementById("gender");
    let genderOption = gender.options[gender.selectedIndex].text;

    let ageDifference = Date.now() - new Date(birthDate).getTime();
    let ageDate = new Date(ageDifference);
    let age = Math.abs(ageDate.getUTCFullYear() - 1970);

    arrAges.push(age);

    const averageAge = arrAges.reduce((a, b) => a + b, 0) / arrAges.length;

    const newRow = studentsTable.insertRow(studentsTable.rows.length);

    const studentNameCell = newRow.insertCell(0);
    const genderCell = newRow.insertCell(1);
    const birthDateCell = newRow.insertCell(2);
    const ageCell = newRow.insertCell(3);

    studentNameCell.appendChild(document.createTextNode(studentName));
    genderCell.appendChild(document.createTextNode(genderOption));
    birthDateCell.appendChild(document.createTextNode(birthDate));
    ageCell.appendChild(document.createTextNode(age));

    const averageAgeCell = document.getElementById("averageAge");
    averageAgeCell.innerHTML = Math.round(averageAge);
}
