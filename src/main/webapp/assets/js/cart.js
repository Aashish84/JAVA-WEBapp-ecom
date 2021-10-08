document.querySelectorAll(".addtocart").forEach(function(item){
	item.addEventListener("click", function(){
		cartadd(item);
	});
});

function cartadd(item){
	xhr= new XMLHttpRequest();
	xhr.onreadystatechange = function (){
		if (this.readyState == 4 && this.status == 200){
			alert("sucessful! check on your cart");
		}
		if(this.readyState == 4 && this.status!=200){
			alert("error to add on cart");
		}
	};
	xhr.open('post',"/ecom/product/CartManager/"+item.nextSibling.innerHTML,true);
	xhr.send();
}

document.querySelectorAll(".carticon").forEach(function(item){
	item.addEventListener("click", function(){
		document.getElementById("idqty"+item.getAttribute("id")).value=0;
		document.getElementById("cartdetail").submit();
	});
});
var total = 0;
document.querySelectorAll(".subtotal").forEach(function (item,index,arr){
	total += parseInt(item.innerHTML);	
});
document.getElementById("total").innerHTML = total;