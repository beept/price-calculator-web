<%-- 
    Document   : js_jsp_middleware
    Created on : 28 de fev. de 2022, 19:01:41
    Author     : Victor Rodrigues at https://github/taveirasrc
--%>

<span id="form-linker"></span>

<script>
  function createForm(method, action)
  {
    let form = document.createElement('form');
    form.method = method;
    form.action = action;
    form.setAttribute('style', 'display: none;');
    return form;
  }

  function createInput(type, name, value)
  {
    let input = document.createElement('input');
    input.type = type;
    input.name = name;
    input.value = value;
    return input;
  }

  function sendInfo()
  {
    let form = createForm('post', 'registerUser.jsp');
    let input = createInput('hidden', 'TestName', 'TestValue');
    let input1 = createInput('hidden', 'TestName1', 'TestValue1');

    form.appendChild(input);
    form.appendChild(input1);

    let linkerElement = document.getElementById('form-linker');
    linkerElement.appendChild(form);
    form.submit();
    linkerElement.removeChild(form);
  }
  sendInfo();
</script>