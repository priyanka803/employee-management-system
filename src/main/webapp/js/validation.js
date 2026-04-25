function validateAge(age) {
    if (age < 18 || age > 60) {
        alert("Invalid age! Must be between 18 and 60.");
        return false;
    }
    return true;
}
