<!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="<%=request.getContextPath()%>/Template/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<%=request.getContextPath()%>/Template/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/Template/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="<%=request.getContextPath()%>/Template/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="<%=request.getContextPath()%>/Template/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="<%=request.getContextPath()%>/Template/plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="<%=request.getContextPath()%>/Template/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="<%=request.getContextPath()%>/Template/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="<%=request.getContextPath()%>/Template/plugins/moment/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/Template/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/Template/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="<%=request.getContextPath()%>/Template/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="<%=request.getContextPath()%>/Template/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/Template/dist/js/adminlte.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="<%=request.getContextPath()%>/Template/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/Template/dist/js/demo.js"></script>
<script src="<%=request.getContextPath()%>/Template/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/Template/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="<%=request.getContextPath()%>/Template/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/Template/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="<%=request.getContextPath()%>/Template/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="<%=request.getContextPath()%>/Template/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/Template//dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/Template/dist/js/demo.js"></script>

<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true,
      "autoWidth": false,
      "oLanguage": {
          "sLengthMenu": "Afficher _MENU_ ligne",
          "sSearch":"Recherche:",
        }
    });
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
      "oLanguage": {
          "sLengthMenu": "Affich _MENU_ records",
        }
    });
  });
</script>