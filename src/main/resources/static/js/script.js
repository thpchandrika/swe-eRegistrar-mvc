function confirmDelete(studentId) {
    const confirmDelete = confirm('Are you sure you want to delete this student?');
    if (confirmDelete) {
        $.ajax({
            type: 'DELETE',
            url: '/eregistrar/students/deleteStudent/' + studentId,
            success: function () {
                location.reload();
            },
            error: function (error) {
                console.error(error);
                alert("Cannot delete student...Try Again..");
            }
        });
    }
}