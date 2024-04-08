<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    p{
        color:red;
    }
</style>

<script>
    $(document).ready(function () {
        $(`#ptag`).text('Replace Text');
        $(`h5`).click(function () {
            alert('글씨 클릭!!');
            $(this).text("짜잔🤸‍♀️");
        })
    })
</script>

<div class="container">
    <h2>HTML1 Page</h2>
    <h5>클릭하면 글씨가 변경됩니다!</h5>
    <div class="fakeimg">Fake Image</div>
    <p id="ptag">Some text..</p>
    <span>Span</span>
    <a href="#">A TAG</a>
</div>