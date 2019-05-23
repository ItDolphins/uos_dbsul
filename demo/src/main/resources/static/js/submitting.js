function staffSubmitting() {

    document.getElementById("staff").setAttribute("staff_name",document.getElementById("staff_name").value);
    document.getElementById("staff").setAttribute("staff_acntbank",document.getElementById("staff_acntbank").value);
    document.getElementById("staff").setAttribute("resign_flag",document.getElementById("resign_flag").value);
    document.getElementById("staff").setAttribute("staff_pos",document.getElementById("staff_pos").value);
    document.getElementById("staff").setAttribute("staff_acntno",document.getElementById("staff_acntno").value);
    document.getElementById("staff").setAttribute("staff_no",document.getElementById("staff_no").value);
    document.getElementById("staff").setAttribute("staff_pnum",document.getElementById("staff_pnum").value);

    return true;
}
