let opSttsElement = document.querySelector('.msgBox');

setTimeout(function removeOpStts() {
  opSttsElement.remove();
  console.log('Remove msg executed');
}, 2000);

