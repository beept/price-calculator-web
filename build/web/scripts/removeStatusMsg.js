let opSttsElement = document.querySelector('.msgBox');
opSttsElement.classList.add("apply-shake");

setTimeout(function removeOpStts() {
  opSttsElement.remove();
  console.log('Remove msg executed');
}, 1500);

