<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let datas = [
        {"id":"id01","name":"james1"},
        {"id":"id02","name":"james2"},
        {"id":"id03","name":"james3"},
        {"id":"id04","name":"james4"},
        {"id":"id05","name":"james5"}
    ];

    let html2 = {

        init:function (){
            $('#btn').click(function(){
                html2.display(datas);
            });
        },
        display:function(datas){
            let result = '';
            $(datas).each(function (index, data) {
                result += '<tr>';
                result += '<td>'+data.id+'</td>';
                result += '<td>'+data.name+'</td>';
                result += '</tr>';
            });
            $('#cust_tb > tbody').html(result);
        }
    };

    $(function(){
        html2.init();
    });

</script>

<div class="container">
    <h2>HTML2 Page</h2>
    <button id="btn" type="button" class="btn btn-success">Success</button>
    <table class="table table-striped" id="cust_tb">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>