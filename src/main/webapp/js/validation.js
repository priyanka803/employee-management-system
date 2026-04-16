function validateAge(age) {
    if (age < 18 || age > 60) {
        alert("Invalid age!");
        return false;
    }
    return true;
}