<%@ include file="../layout/top.inc" %><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">

<div class="wrap">
	<h2>Credits</h2>
	<p>Hi, please donate $:)</p>
</div>

<style>
  #editMe {
    width: 600px;
    height: 300px;
    background-color: white;
    border: 1px solid grey;
  }
</style>

<style>
	@import url(/springnet/_/closure/goog/css/common.css);
	@import url(/springnet/_/closure/goog/css/button.css);
	@import url(/springnet/_/closure/goog/css/dialog.css);
	@import url(/springnet/_/closure/goog/css/linkbutton.css);
	@import url(/springnet/_/closure/goog/css/menu.css);
	@import url(/springnet/_/closure/goog/css/menuitem.css);
	@import url(/springnet/_/closure/goog/css/menuseparator.css);
	@import url(/springnet/_/closure/goog/css/tab.css);
	@import url(/springnet/_/closure/goog/css/tabbar.css);
	@import url(/springnet/_/closure/goog/css/toolbar.css);
	@import url(/springnet/_/closure/goog/css/colormenubutton.css);
	@import url(/springnet/_/closure/goog/css/palette.css);
	@import url(/springnet/_/closure/goog/css/colorpalette.css);
	
	@import url(/springnet/_/closure/goog/css/editor/bubble.css);
	@import url(/springnet/_/closure/goog/css/editor/dialog.css);
	@import url(/springnet/_/closure/goog/css/editor/linkdialog.css);
	@import url(/springnet/_/closure/goog/css/editortoolbar.css);
</style>

<script>
  function updateFieldContents() {
    goog.dom.getElement('fieldContents').value = myField.getCleanContents();
  }

  // Create an editable field.
  var myField = new goog.editor.Field('editMe');

  // Create and register all of the editing plugins you want to use.
  myField.registerPlugin(new goog.editor.plugins.BasicTextFormatter());
  myField.registerPlugin(new goog.editor.plugins.RemoveFormatting());
  myField.registerPlugin(new goog.editor.plugins.UndoRedo());
  myField.registerPlugin(new goog.editor.plugins.ListTabHandler());
  myField.registerPlugin(new goog.editor.plugins.SpacesTabHandler());
  myField.registerPlugin(new goog.editor.plugins.EnterHandler());
  myField.registerPlugin(new goog.editor.plugins.HeaderFormatter());
  myField.registerPlugin(
      new goog.editor.plugins.LoremIpsum('Click here to edit'));
  myField.registerPlugin(
      new goog.editor.plugins.LinkDialogPlugin());
  myField.registerPlugin(new goog.editor.plugins.LinkBubble());

  // Specify the buttons to add to the toolbar, using built in default buttons.
  var buttons = [
    goog.editor.Command.BOLD,
    goog.editor.Command.ITALIC,
    goog.editor.Command.UNDERLINE,
    goog.editor.Command.FONT_COLOR,
    goog.editor.Command.BACKGROUND_COLOR,
    goog.editor.Command.FONT_FACE,
    goog.editor.Command.FONT_SIZE,
    goog.editor.Command.LINK,
    goog.editor.Command.UNDO,
    goog.editor.Command.REDO,
    goog.editor.Command.UNORDERED_LIST,
    goog.editor.Command.ORDERED_LIST,
    goog.editor.Command.INDENT,
    goog.editor.Command.OUTDENT,
    goog.editor.Command.JUSTIFY_LEFT,
    goog.editor.Command.JUSTIFY_CENTER,
    goog.editor.Command.JUSTIFY_RIGHT,
    goog.editor.Command.SUBSCRIPT,
    goog.editor.Command.SUPERSCRIPT,
    goog.editor.Command.STRIKE_THROUGH,
    goog.editor.Command.REMOVE_FORMAT
  ];
  var myToolbar = goog.ui.editor.DefaultToolbar.makeToolbar(buttons,
      goog.dom.getElement('toolbar'));

  // Hook the toolbar into the field.
  var myToolbarController =
      new goog.ui.editor.ToolbarController(myField, myToolbar);

  // Watch for field changes, to display below.
  goog.events.listen(myField, goog.editor.Field.EventType.DELAYEDCHANGE,
      updateFieldContents);

  myField.makeEditable();
  updateFieldContents();
</script>

<div>
	<h1>goog.editor Demo</h1>
  	<p>This is a demonstration of a editable field, with installed plugins,
		hooked up to a toolbar.</p>
 	<br>
	<div id='toolbar' style='width:602px'></div>
 	<div id='editMe'></div>
 	<hr>
 	<p><b>Current field contents</b>
 	(updates as contents of the editable field above change):<br>
 	<textarea id="fieldContents" style="height:100px;width:400px;"></textarea><br>
 	<input type="button" value="Set Field Contents"
     		onclick="myField.setHtml(false, goog.dom.getElement('fieldContents').value);" />
	 		(Use to set contents of the editable field to the contents of this textarea)
	 </p>
</div>

</compress:html>