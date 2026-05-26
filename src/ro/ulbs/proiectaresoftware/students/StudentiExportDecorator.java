package ro.ulbs.proiectaresoftware.students;

public abstract class StudentiExportDecorator implements IStudentiExport {
    protected IStudentiExport exportDecorat;

    public StudentiExportDecorator(IStudentiExport exportDecorat) {
        this.exportDecorat = exportDecorat;
    }
}
