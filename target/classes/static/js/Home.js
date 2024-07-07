const text = "to my Portfolio";
let index = 0;

function typeText() {
    if (index < text.length) {
        document.querySelector(".data").textContent += text.charAt(index);
        index++;
        setTimeout(typeText, 150); 
    }
    else {
        setTimeout(() => {
            document.querySelector(".data").textContent = "Welcome ";
            index = 0;
            typeText(); 
        }, 1000);
    }
}

window.onload = function() {
    typeText();
};


gsap.fromTo(".imageContent",{
    opacity: 0,
    y:100
},{
    opacity: 1,
    y:0,
    duration: 1.5,
    delay: 0.5
})

gsap.fromTo(".data",{
    opacity: 0,
    y:100
},{
    opacity: 1,
    y:0,
    duration: 1.5,
    delay: 0.5
})

gsap.fromTo(".data1", {
    opacity: 0, 
    scale: 1
}, {
    opacity: 2,
    scale: 1.1,
    duration: 2,
    scrollTrigger:".circle1",
});

gsap.fromTo(".data2", {
    opacity: 0, 
    scale: 1
}, {
    opacity: 1.5,
    scale: 1.1,
    duration: 2,
    scrollTrigger:".circle1"
    
});

gsap.fromTo(".circle1",{
    y:70,
    opacity: 0
}, {
    y:0,
    opacity: 1,
    duration: 1,
    scrollTrigger: ".circle1"
});

gsap.fromTo(".circle2",{
    y:70,
    opacity: 0
}, {
    y:0,
    opacity: 1,
    duration: 1,
    delay: 0.5,
    scrollTrigger: ".circle1"
});

gsap.fromTo(".circle3",{
    y:70,
    opacity: 0
}, {
    y:0,
    opacity: 1,
    duration: 1,
    delay: 1,
    scrollTrigger: ".circle1"
});