const consentChk = document.querySelector(`#consentChk`);
const submit_btn = document.querySelector(`input[type=submit]`);

consentChk.addEventListener('change', () => {

  if (consentChk.checked === true) {
    submit_btn.disabled = false;
  } else {
    submit_btn.disabled = true;
  }

});