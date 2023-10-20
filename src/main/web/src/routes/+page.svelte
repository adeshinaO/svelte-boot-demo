<script>
    import CategorizeTransactionModal from "../components/CategorizeTransactionModal.svelte";
    import { getAuth, getRedirectResult, GoogleAuthProvider } from "firebase/auth";

</script>

<div class="flex-row flex font-mono tracking-tight">

   <section >
      <CategorizeTransactionModal/>
   </section>

</div>