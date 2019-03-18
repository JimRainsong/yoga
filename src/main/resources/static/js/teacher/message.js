
$.ajax({
    url: "/yoga/teacher/allappointment",
    type: "post",
    async: false,
    data: {},
    dataType: "json",
    success: function (list) {


        for( var i=0; i< list.length;i++) {
            var b = list[i];
            var  c = "";
            if (b.state==1){
                c="未审核"
            }else if (b.state==0){
                c="已通过"
            }else if (b.state==2){
                c="已拒绝"
            }

            var content =  "<div class=\"mes2\" id="+b.cId+">"+
                "<div class=\"message2\">"+b.uName+"</div>"+
                "<div class=\"message2\">"+b.uName+"</div>"+
                "<div class=\"message2\">"+b.startTime+b.endTime+"</div>"+
                "<div class=\"message2\">"+b.vAddress+"</div>"+
                "<div class=\"message2\">"+c+"</div>"+
                "<div class='line' style='margin-top: 20px'></div>"+
                "<input type='button' value='接受' onclick='accept("+b.cId+")'>"+
                "<input type='button' value='拒绝' onclick='refuse(\"+b.cId+\")'>"+
                "</div>";
            $("#dogs").append(content);
        }
    }
})

function accept(cid) {
    alert(cid);

}
function refuse(cid) {
    alert(cid);
}