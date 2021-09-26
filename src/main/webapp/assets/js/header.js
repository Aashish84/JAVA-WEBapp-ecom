function test(){
    let elem1 = document.querySelector("#b-1");
    elem1.classList.toggle("x");
    let elem2 = document.querySelector("#b-2");
    elem2.classList.toggle("y");
    let elem3 = document.querySelector("#b-3");
    elem3.classList.toggle("z");
    let elem4 = document.querySelector(".nav-links");
    elem4.classList.toggle("nav-links-show");
}

document.getElementsByClassName("icon")[0].addEventListener("click",test);

//dropdown
//link hover
document.getElementById("xyz").onmouseover = function(){
    document.getElementsByClassName("nav-links-second")[0].classList.add("nav-toggle");
}
document.getElementById("xyz").onmouseout = function(){
    document.getElementsByClassName("nav-links-second")[0].classList.remove("nav-toggle");
}
//that div hover
document.getElementById("category-links").onmouseover = function(){
    document.getElementsByClassName("nav-links-second")[0].classList.add("nav-toggle");
}
document.getElementById("category-links").onmouseout = function(){
    document.getElementsByClassName("nav-links-second")[0].classList.remove("nav-toggle");
}
