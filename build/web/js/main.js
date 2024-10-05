//js cho phhân detail
var sl = document.getElementById('item-quantity')
var temp = parseInt(sl.innerHTML);
function clickChange(btn) {

    if (btn.value == '+') {
        temp += 1
        sl.innerHTML = temp + ''
    } else if (temp > 1) {
        temp -= 1
        sl.innerHTML = temp + ''
    }
}

function themSanPham(btn) {
    console.log(window.location.href)
    btn.href = "cart?add=" + btn.id + "&sl=" + temp + "&url=detail?id=" + btn.id
}

// xử lí nộp from thanh toán 

function orderProduct() {
    document.order.submit();
}
// hiệu ứng cick và blur hàng
function clickRow(item) {
    item.classList.add('rowClick')
}
function blurRow(item) {
    item.classList.remove('rowClick')
}

//hiệu ứng nhập lại mật khẩu
function checkPass(pass){
    let pass1 = document.getElementById('pass1').value
    let btn = document.getElementById('btn')
    console.log(pass1+'    '+pass.value)
    if(pass1 != pass.value && pass.classList.contains('failPass')==false){
        pass.classList.remove('rowClick')
        pass.classList.add('failPass')
        btn.type = 'button'
    }else if(pass1 == pass.value){
        pass.classList.remove('failPass')
        pass.classList.add('rowClick')
        btn.type = 'submit'
    }
}