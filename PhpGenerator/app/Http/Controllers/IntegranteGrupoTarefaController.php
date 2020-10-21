<?php

namespace App\Http\Controllers;

use App\DataTables\IntegranteGrupoTarefaDataTable;
use App\Http\Requests;
use App\Http\Requests\CreateIntegranteGrupoTarefaRequest;
use App\Http\Requests\UpdateIntegranteGrupoTarefaRequest;
use App\Repositories\IntegranteGrupoTarefaRepository;
use Flash;
use App\Http\Controllers\AppBaseController;
use Response;
use Illuminate\Support\Facades\DB;

class IntegranteGrupoTarefaController extends AppBaseController
{
    /** @var  IntegranteGrupoTarefaRepository */
    private $integranteGrupoTarefaRepository;

    public function __construct(IntegranteGrupoTarefaRepository $integranteGrupoTarefaRepo)
    {
        $this->integranteGrupoTarefaRepository = $integranteGrupoTarefaRepo;
    }

    /**
     * Display a listing of the IntegranteGrupoTarefa.
     *
     * @param IntegranteGrupoTarefaDataTable $integranteGrupoTarefaDataTable
     * @return Response
     */
    public function index(IntegranteGrupoTarefaDataTable $integranteGrupoTarefaDataTable)
    {
        return $integranteGrupoTarefaDataTable->render('integrante_grupo_tarefas.index');
    }

    /**
     * Show the form for creating a new IntegranteGrupoTarefa.
     *
     * @return Response
     */
    public function create()
    {
        return view('integrante_grupo_tarefas.create');
    }

    /**
     * Store a newly created IntegranteGrupoTarefa in storage.
     *
     * @param CreateIntegranteGrupoTarefaRequest $request
     *
     * @return Response
     */
    public function store(CreateIntegranteGrupoTarefaRequest $request)
    {
        $input = $request->all();

        $integranteGrupoTarefa = $this->integranteGrupoTarefaRepository->create($input);

        Flash::success('Integrante Grupo Tarefa saved successfully.');

        return redirect(route('integranteGrupoTarefas.index'));
    }

    /**
     * Display the specified IntegranteGrupoTarefa.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function show($id)
    {
        $integranteGrupoTarefa = $this->integranteGrupoTarefaRepository->find($id);

        if (empty($integranteGrupoTarefa)) {
            Flash::error('Integrante Grupo Tarefa not found');

            return redirect(route('integranteGrupoTarefas.index'));
        }

        return view('integrante_grupo_tarefas.show')->with('integranteGrupoTarefa', $integranteGrupoTarefa);
    }

    /**
     * Show the form for editing the specified IntegranteGrupoTarefa.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function edit($id)
    {
        $integranteGrupoTarefa = $this->integranteGrupoTarefaRepository->find($id);

        if (empty($integranteGrupoTarefa)) {
            Flash::error('Integrante Grupo Tarefa not found');

            return redirect(route('integranteGrupoTarefas.index'));
        }

        return view('integrante_grupo_tarefas.edit')->with('integranteGrupoTarefa', $integranteGrupoTarefa);
    }

    /**
     * Update the specified IntegranteGrupoTarefa in storage.
     *
     * @param  int              $id
     * @param UpdateIntegranteGrupoTarefaRequest $request
     *
     * @return Response
     */
    public function update($id, UpdateIntegranteGrupoTarefaRequest $request)
    {
        $integranteGrupoTarefa = $this->integranteGrupoTarefaRepository->find($id);

        if (empty($integranteGrupoTarefa)) {
            Flash::error('Integrante Grupo Tarefa not found');

            return redirect(route('integranteGrupoTarefas.index'));
        }

        $integranteGrupoTarefa = $this->integranteGrupoTarefaRepository->update($request->all(), $id);

        Flash::success('Integrante Grupo Tarefa updated successfully.');

        return redirect(route('integranteGrupoTarefas.index'));
    }

    /**
     * Remove the specified IntegranteGrupoTarefa from storage.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function destroy($id)
    {
        $integranteGrupoTarefa = $this->integranteGrupoTarefaRepository->find($id);

        if (empty($integranteGrupoTarefa)) {
            Flash::error('Integrante Grupo Tarefa not found');

            return redirect(route('integranteGrupoTarefas.index'));
        }

        $this->integranteGrupoTarefaRepository->delete($id);

        Flash::success('Integrante Grupo Tarefa deleted successfully.');

        return redirect(route('integranteGrupoTarefas.index'));
    }

    public function undelete($id)
    {
        $integranteGrupoTarefa = DB::table('integrante_grupo_tarefa')
		    ->where('id', $id)->first();

        if (empty($integranteGrupoTarefa)) {
            Flash::error('Integrante Grupo Tarefa not found');

            return redirect(route('integranteGrupoTarefas.index'));
        }

	    DB::table('integrante_grupo_tarefa')
		    ->where('id', $id)
		    ->update(array('deleted_at' => null));

        Flash::success('Integrante Grupo Tarefa undeleted successfully.');

        return redirect(route('integranteGrupoTarefas.index'));
    }

    public function datatableAjax()
    {
	    $lista = DB::table('integrante_grupo_tarefa')
		    ->select(
				'integrante_grupo_tarefa.*'
				)
			->get();
	    return $lista;
    }
}
