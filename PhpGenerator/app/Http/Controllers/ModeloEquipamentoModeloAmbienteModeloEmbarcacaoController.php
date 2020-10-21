<?php

namespace App\Http\Controllers;

use App\DataTables\ModeloEquipamentoModeloAmbienteModeloEmbarcacaoDataTable;
use App\Http\Requests;
use App\Http\Requests\CreateModeloEquipamentoModeloAmbienteModeloEmbarcacaoRequest;
use App\Http\Requests\UpdateModeloEquipamentoModeloAmbienteModeloEmbarcacaoRequest;
use App\Repositories\ModeloEquipamentoModeloAmbienteModeloEmbarcacaoRepository;
use Flash;
use App\Http\Controllers\AppBaseController;
use Response;
use Illuminate\Support\Facades\DB;

class ModeloEquipamentoModeloAmbienteModeloEmbarcacaoController extends AppBaseController
{
    /** @var  ModeloEquipamentoModeloAmbienteModeloEmbarcacaoRepository */
    private $modeloEquipamentoModeloAmbienteModeloEmbarcacaoRepository;

    public function __construct(ModeloEquipamentoModeloAmbienteModeloEmbarcacaoRepository $modeloEquipamentoModeloAmbienteModeloEmbarcacaoRepo)
    {
        $this->modeloEquipamentoModeloAmbienteModeloEmbarcacaoRepository = $modeloEquipamentoModeloAmbienteModeloEmbarcacaoRepo;
    }

    /**
     * Display a listing of the ModeloEquipamentoModeloAmbienteModeloEmbarcacao.
     *
     * @param ModeloEquipamentoModeloAmbienteModeloEmbarcacaoDataTable $modeloEquipamentoModeloAmbienteModeloEmbarcacaoDataTable
     * @return Response
     */
    public function index(ModeloEquipamentoModeloAmbienteModeloEmbarcacaoDataTable $modeloEquipamentoModeloAmbienteModeloEmbarcacaoDataTable)
    {
        return $modeloEquipamentoModeloAmbienteModeloEmbarcacaoDataTable->render('modelo_equipamento_modelo_ambiente_modelo_embarcacaos.index');
    }

    /**
     * Show the form for creating a new ModeloEquipamentoModeloAmbienteModeloEmbarcacao.
     *
     * @return Response
     */
    public function create()
    {
        return view('modelo_equipamento_modelo_ambiente_modelo_embarcacaos.create');
    }

    /**
     * Store a newly created ModeloEquipamentoModeloAmbienteModeloEmbarcacao in storage.
     *
     * @param CreateModeloEquipamentoModeloAmbienteModeloEmbarcacaoRequest $request
     *
     * @return Response
     */
    public function store(CreateModeloEquipamentoModeloAmbienteModeloEmbarcacaoRequest $request)
    {
        $input = $request->all();

        $modeloEquipamentoModeloAmbienteModeloEmbarcacao = $this->modeloEquipamentoModeloAmbienteModeloEmbarcacaoRepository->create($input);

        Flash::success('Modelo Equipamento Modelo Ambiente Modelo Embarcacao saved successfully.');

        return redirect(route('modeloEquipamentoModeloAmbienteModeloEmbarcacaos.index'));
    }

    /**
     * Display the specified ModeloEquipamentoModeloAmbienteModeloEmbarcacao.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function show($id)
    {
        $modeloEquipamentoModeloAmbienteModeloEmbarcacao = $this->modeloEquipamentoModeloAmbienteModeloEmbarcacaoRepository->find($id);

        if (empty($modeloEquipamentoModeloAmbienteModeloEmbarcacao)) {
            Flash::error('Modelo Equipamento Modelo Ambiente Modelo Embarcacao not found');

            return redirect(route('modeloEquipamentoModeloAmbienteModeloEmbarcacaos.index'));
        }

        return view('modelo_equipamento_modelo_ambiente_modelo_embarcacaos.show')->with('modeloEquipamentoModeloAmbienteModeloEmbarcacao', $modeloEquipamentoModeloAmbienteModeloEmbarcacao);
    }

    /**
     * Show the form for editing the specified ModeloEquipamentoModeloAmbienteModeloEmbarcacao.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function edit($id)
    {
        $modeloEquipamentoModeloAmbienteModeloEmbarcacao = $this->modeloEquipamentoModeloAmbienteModeloEmbarcacaoRepository->find($id);

        if (empty($modeloEquipamentoModeloAmbienteModeloEmbarcacao)) {
            Flash::error('Modelo Equipamento Modelo Ambiente Modelo Embarcacao not found');

            return redirect(route('modeloEquipamentoModeloAmbienteModeloEmbarcacaos.index'));
        }

        return view('modelo_equipamento_modelo_ambiente_modelo_embarcacaos.edit')->with('modeloEquipamentoModeloAmbienteModeloEmbarcacao', $modeloEquipamentoModeloAmbienteModeloEmbarcacao);
    }

    /**
     * Update the specified ModeloEquipamentoModeloAmbienteModeloEmbarcacao in storage.
     *
     * @param  int              $id
     * @param UpdateModeloEquipamentoModeloAmbienteModeloEmbarcacaoRequest $request
     *
     * @return Response
     */
    public function update($id, UpdateModeloEquipamentoModeloAmbienteModeloEmbarcacaoRequest $request)
    {
        $modeloEquipamentoModeloAmbienteModeloEmbarcacao = $this->modeloEquipamentoModeloAmbienteModeloEmbarcacaoRepository->find($id);

        if (empty($modeloEquipamentoModeloAmbienteModeloEmbarcacao)) {
            Flash::error('Modelo Equipamento Modelo Ambiente Modelo Embarcacao not found');

            return redirect(route('modeloEquipamentoModeloAmbienteModeloEmbarcacaos.index'));
        }

        $modeloEquipamentoModeloAmbienteModeloEmbarcacao = $this->modeloEquipamentoModeloAmbienteModeloEmbarcacaoRepository->update($request->all(), $id);

        Flash::success('Modelo Equipamento Modelo Ambiente Modelo Embarcacao updated successfully.');

        return redirect(route('modeloEquipamentoModeloAmbienteModeloEmbarcacaos.index'));
    }

    /**
     * Remove the specified ModeloEquipamentoModeloAmbienteModeloEmbarcacao from storage.
     *
     * @param  int $id
     *
     * @return Response
     */
    public function destroy($id)
    {
        $modeloEquipamentoModeloAmbienteModeloEmbarcacao = $this->modeloEquipamentoModeloAmbienteModeloEmbarcacaoRepository->find($id);

        if (empty($modeloEquipamentoModeloAmbienteModeloEmbarcacao)) {
            Flash::error('Modelo Equipamento Modelo Ambiente Modelo Embarcacao not found');

            return redirect(route('modeloEquipamentoModeloAmbienteModeloEmbarcacaos.index'));
        }

        $this->modeloEquipamentoModeloAmbienteModeloEmbarcacaoRepository->delete($id);

        Flash::success('Modelo Equipamento Modelo Ambiente Modelo Embarcacao deleted successfully.');

        return redirect(route('modeloEquipamentoModeloAmbienteModeloEmbarcacaos.index'));
    }

    public function undelete($id)
    {
        $modeloEquipamentoModeloAmbienteModeloEmbarcacao = DB::table('modelo_equipamento_modelo_ambiente_modelo_embarcacao')
		    ->where('id', $id)->first();

        if (empty($modeloEquipamentoModeloAmbienteModeloEmbarcacao)) {
            Flash::error('Modelo Equipamento Modelo Ambiente Modelo Embarcacao not found');

            return redirect(route('modeloEquipamentoModeloAmbienteModeloEmbarcacaos.index'));
        }

	    DB::table('modelo_equipamento_modelo_ambiente_modelo_embarcacao')
		    ->where('id', $id)
		    ->update(array('deleted_at' => null));

        Flash::success('Modelo Equipamento Modelo Ambiente Modelo Embarcacao undeleted successfully.');

        return redirect(route('modeloEquipamentoModeloAmbienteModeloEmbarcacaos.index'));
    }

    public function datatableAjax()
    {
	    $lista = DB::table('modelo_equipamento_modelo_ambiente_modelo_embarcacao')
		    ->select(
				'modelo_equipamento_modelo_ambiente_modelo_embarcacao.*'
				)
			->get();
	    return $lista;
    }
}
