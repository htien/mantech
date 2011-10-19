<%@ include file="../layout/top.inc"%><compress:html jsCompressor="closure" compressJavaScript="true" compressCss="true" removeIntertagSpaces="true">


<!-- *********************************************** -->
<div id="pagelet_addcomplaint" class="g-pl">
	<div id="addcomplaint-box" class="box wrap">
		<h2 class="title">Create New Complaint</h2>
		<form id="addcomplaint-form" class="g-f" method="post"
			action="/complaint/addSave">
			<div id="complaint-new" class="gg-has-right-sidebar">
				<div class="gg-inner-sidebar">
					<div class="gg-postbox">
						<div class="gg-handlediv"></div>
						<h3 class="gg-title">
							<span>Publish</span>
						</h3>
						<div class="gg-submitbox">
							<div class="gg-options">
								<div class="misc-pub-section">
									<p>
										Compose your complaint and press <strong>Submit</strong> for
										reporting to administrator.
									</p>
								</div>
								<div class="misc-pub-section">
									<label>Sender:</label> <strong> ${user.firstName}
										${user.lastName}</strong>
								</div>
								<div class="misc-pub-section">
									<label for="equipid">Report on the equipment:</label>
									<select id="equipid" name="equip_id" class="noreset">
										<c:forEach items="${list}" var="equip">
											<option value="${equip.id}">${equip.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="gg-actions">
								<div id="btnAdd" class="g-b g-b-r">Submit</div>
								<div id="btnReset" class="g-b g-b-b">Reset</div>
							</div>
						</div>
					</div>
				</div>
				<script type="text/javascript">
					var complaintEditor = new goog.editor.Field('editor');
					complaintEditor.registerPlugin(new goog.editor.plugins.BasicTextFormatter());
					complaintEditor.registerPlugin(new goog.editor.plugins.RemoveFormatting());
					complaintEditor.registerPlugin(new goog.editor.plugins.UndoRedo());
					complaintEditor.registerPlugin(new goog.editor.plugins.ListTabHandler());
					complaintEditor.registerPlugin(new goog.editor.plugins.SpacesTabHandler());
					complaintEditor.registerPlugin(new goog.editor.plugins.EnterHandler());
					complaintEditor.registerPlugin(new goog.editor.plugins.HeaderFormatter());
					complaintEditor.registerPlugin(new goog.editor.plugins.LoremIpsum('Click here to add content'));
					complaintEditor.registerPlugin(new goog.editor.plugins.LinkDialogPlugin());
					complaintEditor.registerPlugin(new goog.editor.plugins.LinkBubble());
					
					var buttons = [
							goog.editor.Command.BOLD,
							goog.editor.Command.ITALIC,
							goog.editor.Command.UNDERLINE,
							goog.editor.Command.FONT_COLOR,
							goog.editor.Command.FONT_SIZE,
							goog.editor.Command.LINK,
							goog.editor.Command.UNDO,
							goog.editor.Command.REDO,
							goog.editor.Command.UNORDERED_LIST,
							goog.editor.Command.ORDERED_LIST,
							goog.editor.Command.INDENT,
							goog.editor.Command.OUTDENT,
							goog.editor.Command.REMOVE_FORMAT
						],
						editorToolbar = goog.ui.editor.DefaultToolbar.makeToolbar(buttons,
								goog.dom.getElement('editor-toolbar')),
						toolbarController = new goog.ui.editor.ToolbarController(complaintEditor, editorToolbar);

					goog.events.listen(complaintEditor, goog.editor.Field.EventType.DELAYEDCHANGE,
						      updateComplaintContents);
					
					complaintEditor.makeEditable();
					updateComplaintContents();
					
					function updateComplaintContents() {
						goog.dom.getElement('content').value = complaintEditor.getCleanContents();
					}
					
					function getComplaintContents() {
						complaintEditor.setHtml(false, goog.dom.getElement('content').value);
					}
				</script>
				<div class="gg-postbox-container">
					<div class="gg-body-content">
						<div id="complaint-titlediv">
							<div id="complaint-titlewrap">
								<input type="text" id="title" name="complaint_title" size="30" />
							</div>
							<div class="gg-inside"></div>
						</div>
						<div id="complaint-postdiv">
							<div id="editor-toolbar"></div>
							<div id="editor-container">
								<div id="editor"></div>
							</div>
							<textarea id="content" name="complaint_content"></textarea>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>

</compress:html>