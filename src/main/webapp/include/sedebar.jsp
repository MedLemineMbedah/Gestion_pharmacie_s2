<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index.html" class="brand-link">
      <img src="logojpg.jpg" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">Pharmacie <i class="nav-icon fas fa-product-hunt "></i></span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="Template/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">
				<%=session.getAttribute("nom") %>
				<%=session.getAttribute("prenom") %>
		</a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item ">
            <a href="login" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              
                Gestion Du Pharmacie
              </p>
            </a>
           
         <!-- Gestion des produits -->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
            
             
              <i class="nav-icon fab fa-product-hunt "></i>
              <p>
                Produits
                <i class="fas fa-angle-left right"></i>
                <span class="badge badge-info right"></span>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="medicament?type=/new" class="nav-link">
					
                  <i class="far fa-circle nav-icon"></i>
                  <p>Ajouter</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="medicament" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Liste Des Produits</p>
                </a>
              </li>
              
              
            </ul>
          </li>
          <!-- Fin de gestion du produit -->
          <!-- Debut des  fournisseur -->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-user"></i>
              <p>
                Fournisseur
                <i class="fas fa-angle-left right"></i>
                <span class="badge badge-info right"></span>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="fournisseurs?type=/new" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Ajouter</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="fournisseurs" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Liste Des Fournisseur</p>
                </a>
              </li>
              
              
            </ul>
          </li>
          <!-- Fin Gestion des Fournisseur -->

          <!-- Gestion des achat -->
          <!-- a-buy-n-large:before{content:"\f8a6"}.fa-buysellads  fa-buysellads-->
          <!-- fa,.fab,.fad,.fal,.far,.fas -->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fab fa-buy-n-large"></i>
              <p>
                  Achats
                <i class="fas fa-angle-left right"></i>
                <span class="badge badge-info right"></span>
              </p>
            </a>
            <ul class="nav nav-treeview">
               <li class="nav-item">
                <a href="achat?type=/ajout" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Faire un Achat</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="achat" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Liste Des Achats effectuer</p>
                </a>
              </li>
             </ul>
          </li>
          <!-- Fin de gestion des achats -->
          <!-- Debut gestion de Vente -->
          <li class="nav-item has-treeview">
            <a href="vente" class="nav-link">
              <i class="nav-icon fab fa-salesforce"></i>
              <p>
                Vente
                <i class="fas fa-angle-left right"></i>
                <span class="badge badge-info right"></span>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="vente?type=/ajout" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Faire une vente</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="vente" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List des ventes</p>
                </a>
              </li>
              
              
            </ul>
          </li>
          <!-- Fin de gestion de vente -->
           <!-- Fin de gestion des achats -->
          <!-- Debut gestion de clients -->
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-user"></i>
              <p>
                Clients
                <i class="fas fa-angle-left right"></i>
                <span class="badge badge-info right"></span>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="clients?type=/new" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Ajouter clients</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="clients" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List des clients</p>
                </a>
              </li>
              
              
            </ul>
          </li>
          <!-- Fin de gestion de clients -->
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>