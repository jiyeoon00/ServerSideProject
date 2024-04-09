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