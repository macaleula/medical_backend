<?php

namespace App\Http\Controllers;

use App\DataTables\ModeloEquipamentoEnvolvidoDataTable;
use App\Http\Requests;
use App\Http\Requests\CreateModeloEquipamentoEnvolvidoRequest;
use App\Http\Requests\UpdateModeloEquipamentoEnvolvidoRequest;
use App\Repositories\ModeloEquipamentoEnvolvidoRepository;
use Flash;
use App\Http\Controllers\AppBaseController;
use Response;
use Illuminate\Support\Facades\DB;

class ModeloEquipamentoEnvolvidoController extends AppBaseController
{
    /** @var  ModeloEquipamentoEnvolvidoRepository */
    private $modeloEquipamentoEnvolvidoRepository;

    public function __construct(ModeloEquipamentoEnvolvidoRepository $modeloEquipamentoEnvolvidoRepo)
    {
        $this->modeloEquipamentoEnvolvidoRepository = $modeloEquipamentoEnvolvidoRepo;
    }

    /**
     * Display a listing of the ModeloEquipamentoEnvolvido.
     *
     * @param ModeloEquipamentoEnvolvidoDataTable $modeloEquipamentoEnvolvidoDataTable
     * @return Response
     */
    public function index(ModeloEquipamentoEnvolvidoDataTable $modeloEquipamentoEnvolvidoDataTable)
    {
        return $modeloEquipamentoEnvolvidoDataTable->render('modelo_equipamento_envolvidos.index');
    }

    /**
     * Show the form for creating a new ModeloEquipamentoEnvolvido.
     *
     * @return Response
     */
    public function create()
    {
        return view('modelo_equipamento_envolvidos.create');
    }

    /**
     * Store a newly created ModeloEquipamentoEnvolvido in storage.
     *
     * @param CreateModeloEquipamentoEnvolvidoRequest $request
     *
     * @return Response
     */
    public function store(CreateModeloEquipamentoEnvolvidoRequest $request)
    {
        $input = $request->all();

        $modeloEquipamentoEnvolvido = $this->modeloEquipamentoEnvolvidoRepository->create($input);

        Flash::success('Modelo Equipamento Envolvido saved successfully.');

        return redirect(route('modeloEquipamentoEnvolvidos.index'));
    }

    /**
     * Display the specified ModeloEquipamentoEnvolvido.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function show($id)
    {
        $modeloEquipamentoEnvolvido = $this->modeloEquipamentoEnvolvidoRepository->find($id);

        if (empty($modeloEquipamentoEnvolvido)) {
            Flash::error('Modelo Equipamento Envolvido not found');

            return redirect(route('modeloEquipamentoEnvolvidos.index'));
        }

        return view('modelo_equipamento_envolvidos.show')->with('modeloEquipamentoEnvolvido', $modeloEquipamentoEnvolvido);
    }

    /**
     * Show the form for editing the specified ModeloEquipamentoEnvolvido.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function edit($id)
    {
        $modeloEquipamentoEnvolvido = $this->modeloEquipamentoEnvolvidoRepository->find($id);

        if (empty($modeloEquipamentoEnvolvido)) {
            Flash::error('Modelo Equipamento Envolvido not found');

            return redirect(route('modeloEquipamentoEnvolvidos.index'));
        }

        return view('modelo_equipamento_envolvidos.edit')->with('modeloEquipamentoEnvolvido', $modeloEquipamentoEnvolvido);
    }

    /**
     * Update the specified ModeloEquipamentoEnvolvido in storage.
     *
     * @param  int              $id
     * @param UpdateModeloEquipamentoEnvolvidoRequest $request
     *
     * @return Response
     */
    public function update($id, UpdateModeloEquipamentoEnvolvidoRequest $request)
    {
        $modeloEquipamentoEnvolvido = $this->modeloEquipamentoEnvolvidoRepository->find($id);

        if (empty($modeloEquipamentoEnvolvido)) {
            Flash::error('Modelo Equipamento Envolvido not found');

            return redirect(route('modeloEquipamentoEnvolvidos.index'));
        }

        $modeloEquipamentoEnvolvido = $this->modeloEquipamentoEnvolvidoRepository->update($request->all(), $id);

        Flash::success('Modelo Equipamento Envolvido updated successfully.');

        return redirect(route('modeloEquipamentoEnvolvidos.index'));
    }

    /**
     * Remove the specified ModeloEquipamentoEnvolvido from storage.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function destroy($id)
    {
        $modeloEquipamentoEnvolvido = $this->modeloEquipamentoEnvolvidoRepository->find($id);

        if (empty($modeloEquipamentoEnvolvido)) {
            Flash::error('Modelo Equipamento Envolvido not found');

            return redirect(route('modeloEquipamentoEnvolvidos.index'));
        }

        $this->modeloEquipamentoEnvolvidoRepository->delete($id);

        Flash::success('Modelo Equipamento Envolvido deleted successfully.');

        return redirect(route('modeloEquipamentoEnvolvidos.index'));
    }

    public function undelete($id)
    {
        $modeloEquipamentoEnvolvido = DB::table('modelo_equipamento_envolvido')
		    ->where('id', $id)->first();

        if (empty($modeloEquipamentoEnvolvido)) {
            Flash::error('Modelo Equipamento Envolvido not found');

            return redirect(route('modeloEquipamentoEnvolvidos.index'));
        }

	    DB::table('modelo_equipamento_envolvido')
		    ->where('id', $id)
		    ->update(array('deleted_at' => null));

        Flash::success('Modelo Equipamento Envolvido undeleted successfully.');

        return redirect(route('modeloEquipamentoEnvolvidos.index'));
    }

    public function datatableAjax()
    {
	    $lista = DB::table('modelo_equipamento_envolvido')
		    ->select(
				'modelo_equipamento_envolvido.*'
				)
			->get();
	    return $lista;
    }
}
